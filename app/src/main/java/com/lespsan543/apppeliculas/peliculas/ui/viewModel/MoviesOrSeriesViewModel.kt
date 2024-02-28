package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lespsan543.apppeliculas.guardar.Property1
import com.lespsan543.apppeliculas.peliculas.domain.GetMovieOrSerieUseCase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel responsable del flujo de películas y series conectándose a la API, además
 * de añadir las películas o series a la base de datos que el usuario añada a favoritos
 *
 * @property auth Instancia de FirebaseAuth utilizada para obtener el usuario actual
 * @property firestore Instancia de FirebaseFirestore utilizada para operaciones en la base de datos
 * @property getMovieOrSerieUseCase caso de uso para invocar la función que busca una película o serie en la base de datos
 * @property names lista con palabras que le pasaremos a la API para que haga la búsqueda
 * @property _moviePosition flujo de datos que mantiene la posición de la película que se va a mostrar al usuario
 * @property moviePosition estado público de la posición de la película o serie
 * @property _seriePosition flujo de datos que mantiene la posición de la serie que se va a mostrar al usuario
 * @property seriePosition estado público de la posición de la serie
 * @property _movieCounter guarda las veces que se pide una película en concreto a la API
 * @property _serieCounter guarda las veces que se pide una película en concreto a la API
 * @property _loopMovieCounter controla si ya se ha realizado una búsqueda por cada película
 * @property _loopSerieCounter controla si ya se ha realizado una búsqueda por cada serie
 * @property movie datos de la película actual que se está mostrando
 * @property serie datos de la serie actual que se está mostrando
 * @property _movieList flujo de datos de las películas que se han recogido en la API
 * @property movieList estado público de la lista de películas recogida
 * @property _serieList flujo de datos de las series que se han encontrado en la API
 * @property serieList estado público de la lista de series recogida
 * @property _propertyButton flujo de datos de la propiedad en la que se encuetra en botón de guardado
 * @property propertyButton estado público de la propiedad del botón de guardado
 * @property _actualMovie flujo de datos de la posición de la película que se está mostrando actualmente
 * @property _actualSerie flujo de datos de la posición de la serie que se está mostrando actualmente
 * @property _moviesInDB flujo de datos de las películas que se han recogido de la base de datos
 */
class MoviesOrSeriesViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private val getMovieOrSerieUseCase = GetMovieOrSerieUseCase()

    private val names = listOf("dragon", "hunger", "divergent", "star", "ring", "potter", "galaxy", "with", "magic", "love", "one", "avengers")

    private var _moviePosition = MutableStateFlow(0)
    var moviePosition : StateFlow<Int> = _moviePosition

    private var _seriePosition = MutableStateFlow(0)
    var seriePosition : StateFlow<Int> = _seriePosition

    private var _movieCounter = MutableStateFlow(0)

    private var _serieCounter = MutableStateFlow(0)

    private var _loopMovieCounter = MutableStateFlow(0)

    private var _loopSerieCounter = MutableStateFlow(0)

    private var movie = MutableStateFlow(MovieState())

    private var serie = MutableStateFlow(MovieState())

    private var _movieList = MutableStateFlow<List<MovieState>>(emptyList())
    var movieList : StateFlow<List<MovieState>> = _movieList.asStateFlow()

    private var _serieList = MutableStateFlow<List<MovieState>>(emptyList())
    var serieList : StateFlow<List<MovieState>> = _serieList.asStateFlow()

    private var _propertyButton = MutableStateFlow(Property1.Default)
    var propertyButton : StateFlow<Property1> = _propertyButton

    private var _actualMovie = MutableStateFlow(0)

    private var _actualSerie = MutableStateFlow(0)

    private var _moviesInDB = MutableStateFlow<List<MovieState>>(emptyList())

    init {
        //Hacemos una primera búsqueda de películas y series al iniciar la aplicación
        getAllMovies()
        getAllSeries()
    }

    /**
     * Buscamos una lista de películas en la API
     */
     fun getAllMovies(){
         viewModelScope.launch {
             val lista = mutableListOf<MovieState>()
             //Por cada nombre en la lista, buscamos una película con esa palabra
             for (element in names){
                 _actualMovie.value = names.indexOf(element)
                 movie.value = getMovieOrSerieUseCase.invoke(element,_movieCounter.value, "Movie")
                 //Si la película tiene poster, la añadimos en la lista para mostrarla
                 if (movie.value.poster != "N/A"){
                     lista.add(movie.value)
                 }
             }
             _movieList.value = lista
             _loopMovieCounter.value++
         }
     }

    /**
     * Buscamos una lista de series en la API
     */
    fun getAllSeries(){
        viewModelScope.launch {
            val lista = mutableListOf<MovieState>()
            //Por cada nombre en la lista, buscamos una serie con esa palabra
            for (element in names){
                _actualSerie.value = names.indexOf(element)
                serie.value = getMovieOrSerieUseCase.invoke(element,_serieCounter.value, "Serie")
                //Si la serie tiene poster, la añadimos en la lista para mostrarla
                if (serie.value.poster != "N/A"){
                    lista.add(serie.value)
                }
            }
            _serieList.value = lista
            _loopSerieCounter.value++
        }
    }

    /**
     * Comprueba si el nombre de la película ya se encuentra en la base de datos
     * para mostrar el botón de guardado correspondiente
     *
     * @param title título de la película o serie que queremos comprobar
     */
    fun findMovieInList(title: String){
        for (movie in _moviesInDB.value) {
            if (title == movie.title){
                _propertyButton.value = Property1.Guardado
            }
        }
    }

    /**
     * Busca todas las películas y series que ya están añadidas a favoritos
     * en la base de datos
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
     * Busca nuevas películas si se cumplen las condiciones
     */
    fun newMovies(){
        //Si se está mostrando la última película de la lista
        //busca nuevas películas en la base de datos
        if (_loopMovieCounter.value == _movieList.value.size){
            _loopMovieCounter.value = 0
            _moviePosition.value = 0
            _movieCounter.value++
            getAllMovies()
        }else{
            //Si no, muestra la siguiente película y añade uno al contador de bucle
            //para ir comprobando si se encuentra en la última de la lista
            _propertyButton.value = Property1.Default
            _moviePosition.value++
            _loopMovieCounter.value++
        }
    }

    /**
     * Busca nuevas series si se cumplen las condiciones
     */
    fun newSeries(){
        //Si se está mostrando la última serie de la lista
        //busca nuevas series en la base de datos
        if (_loopSerieCounter.value == _serieList.value.size){
            _loopSerieCounter.value = 0
            _seriePosition.value = 0
            _serieCounter.value++
            getAllSeries()
        }else{
            //Si no, muestra la siguiente serie y añade uno al contador de bucle
            //para ir comprobando si se encuentra en la última de la lista
            _propertyButton.value = Property1.Default
            _seriePosition.value++
            _loopSerieCounter.value++
        }
    }

    /**
     * Cambia la propiedad del botón de guardado dependiendo de cuando se pulsa
     */
    fun guardarPeliculaOSerie(){
        if (_propertyButton.value == Property1.Default){
            _propertyButton.value = Property1.Guardado
        }else{
            _propertyButton.value = Property1.Default
        }
    }

    /**
     * Guarda la película o serie que se le indica en la base de datos
     *
     * @param movieState película o serie que queremos añadir a favoritos
     */
    fun saveMovieOrSerie(movieState: MovieState) {
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newMovieOrSerie = hashMapOf(
                    "title" to movieState.title,
                    "poster" to movieState.poster,
                    "imdbID" to movieState.imdbID,
                    "type" to movieState.type,
                    "year" to movieState.year,
                    "emailUser" to email.toString()
                )
                firestore.collection("Favoritos")
                    .add(newMovieOrSerie)
                    .addOnSuccessListener {
                        guardarPeliculaOSerie()
                    }
                    .addOnFailureListener {
                        throw Exception()
                    }
            } catch (e: Exception){
                _propertyButton.value = Property1.Default
            }
        }
    }

    /**
     * Elimina una película o serie de la base de datos a partir de su id
     *
     * @param id identificador de la película o serie que se quiere eliminar
     */
    fun deleteMovieOrSerie(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                firestore.collection("Favoritos").document(id)
                    .delete()
                    .addOnSuccessListener {
                        guardarPeliculaOSerie()
                    }
                    .addOnFailureListener {
                        _propertyButton.value = Property1.Guardado
                        throw Exception()
                    }
            } catch (e:Exception) {
                _propertyButton.value = Property1.Guardado
            }
        }
    }
}