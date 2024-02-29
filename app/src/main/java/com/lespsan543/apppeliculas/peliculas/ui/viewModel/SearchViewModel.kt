package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lespsan543.apppeliculas.guardar.Property1
import com.lespsan543.apppeliculas.peliculas.domain.FindMoviesOrSeriesUseCase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @property auth Instancia de FirebaseAuth utilizada para obtener el usuario actual
 * @property firestore Instancia de FirebaseFirestore utilizada para operaciones en la base de datos
 * @property findMoviesOrSeriesUseCase caso de uso para buscar películas y series a partir de un título
 * @property _moviesAndSeriesList flujo de datos con la lista de películas y series que se ha encontrado de la API
 * @property moviesAndSeriesList estado público de la lista de películas y series que se han obtenido
 * @property movieOrSerie titulo de la película o serie de la que el usuario va a realizar la búsqueda
 * @property listOfPropertyButtons lista que guarda las propiedades de todos los botones de favoritos que se han generado con la búsqueda
 * @property _moviesInDB flujo de datos de las películas que se han recogido de la base de datos
 * @property _actualState flujo de datos de la película o serie actual que se está mostrando con los datos de la base de datos
 */
class SearchViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private val findMoviesOrSeriesUseCase = FindMoviesOrSeriesUseCase()

    private var _moviesAndSeriesList = MutableStateFlow<List<MovieState>>(emptyList())
    var moviesAndSeriesList : StateFlow<List<MovieState>> = _moviesAndSeriesList.asStateFlow()

    var movieOrSerie by mutableStateOf("")
        private set

    var listOfPropertyButtons = mutableListOf<Property1>()

    private var _moviesInDB = MutableStateFlow<List<MovieState>>(emptyList())

    private var _actualState = MutableStateFlow(MovieState())

    /**
     * Guarda en la variable el título que escribe el usuario
     *
     * @param movieOrSerie título de la película o serie a buscar
     */
    fun writeMovieOrSerie(movieOrSerie:String){
        this.movieOrSerie = movieOrSerie
    }

    /**
     * Genera una lista de propiedades con el valor para un botón de guardar por cada resultado
     */
    fun generatePropertyButtons(){
        viewModelScope.launch {
            listOfPropertyButtons.clear()
            for (movie in _moviesAndSeriesList.value){
                //Comprobamos si la película ya está añadida a favoritos
                if (findMovieInList(movie.title)){
                    listOfPropertyButtons.add(Property1.Guardado)
                }else{
                    listOfPropertyButtons.add(Property1.Default)
                }
            }
        }
    }

    /**
     * Comprueba si el nombre de la película ya se encuentra en la base de datos
     * para mostrar el botón de guardado correspondiente
     *
     * @param title título de la película o serie que queremos comprobar
     */
    private fun findMovieInList(title: String) :Boolean{
        var result =false
        for (movie in _moviesInDB.value) {
            if (title == movie.title) {
                result = true
                _actualState.value = movie
                break
            }
        }
        return result
    }

    /**
     * Obtiene la posición de la película o serie en la lista de resultados
     *
     * @param movieOrSerie película o serie a buscar
     * @return índice del elemento en la lista
     */
    fun findInList(movieOrSerie:MovieState): Int {
        return _moviesAndSeriesList.value.indexOf(movieOrSerie)
    }

    /**
     * Busca todas las películas y series que ya están añadidas a favoritos en la base de datos
     */
    fun fetchMoviesInDB() {
        val email = auth.currentUser?.email
        firestore.collection("Favoritos")
            .whereEqualTo("emailUser", email.toString())
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val movies = mutableListOf<MovieState>()
                if (querySnapshot != null) {
                    for (document in querySnapshot) {
                        val movie = document.toObject(MovieState::class.java)
                        movie.idDoc = document.id
                        movies.add(movie)
                    }
                }
                _moviesInDB.value = movies
            }
    }

    /**
     * Busca series y películas que incluyan el título proporcionado por el usuario
     */
    fun findMoviesOrSeries(){
        viewModelScope.launch {
            val search = findMoviesOrSeriesUseCase.invoke(movieOrSerie = movieOrSerie)
            _moviesAndSeriesList.value = search.search
            //Genera la lista de propiedades para los botones de guardar
            generatePropertyButtons()
        }
    }

    /**
     * Cambia la propiedad del botón de guardado del que se le indica dependiendo de cuando se pulsa
     *
     * @param index índice de la propiedad del botón que hay que modificar
     */
    private fun guardarPeliculaOSerie(index : Int){
        if (listOfPropertyButtons[index] == Property1.Default){
            listOfPropertyButtons[index] = Property1.Guardado
        }else{
            listOfPropertyButtons[index] = Property1.Default
        }
    }

    /**
     * Guarda la película o serie que se le indica en la base de datos
     *
     * @param movieState película o serie que queremos añadir a favoritos
     */
    fun saveMovieOrSerie(movieState: MovieState, index:Int) {
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newMovieOrSerie = hashMapOf(
                    "title" to movieState.title,
                    "poster" to movieState.poster,
                    "id" to movieState.imdbID,
                    "type" to movieState.type,
                    "year" to movieState.year,
                    "emailUser" to email.toString()
                )
                firestore.collection("Favoritos")
                    .add(newMovieOrSerie)
                    .addOnSuccessListener {
                        guardarPeliculaOSerie(index)
                    }
                    .addOnFailureListener {
                        throw Exception()
                    }
            } catch (e: Exception){
                listOfPropertyButtons[index] = Property1.Default
            }
        }
    }

    /**
     * Elimina una película o serie de la base de datos a partir de su id
     *
     * @param id identificador de la película o serie que se quiere eliminar
     */
    fun deleteMovieOrSerie(index:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                firestore.collection("Favoritos").document(_actualState.value.idDoc)
                    .delete()
                    .addOnSuccessListener {
                        guardarPeliculaOSerie(index)
                    }
                    .addOnFailureListener {
                        listOfPropertyButtons[index] = Property1.Guardado
                        throw Exception()
                    }
            } catch (e:Exception) {
                listOfPropertyButtons[index] = Property1.Guardado
            }
        }
    }

    /**
     * Reinicia el título que ha indicado el usuario
     */
    fun resetMovieOrSerie(){
        movieOrSerie = ""
    }
}