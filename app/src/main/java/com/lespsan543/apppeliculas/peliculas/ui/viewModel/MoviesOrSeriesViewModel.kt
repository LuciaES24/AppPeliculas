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
import com.lespsan543.apppeliculas.peliculas.domain.GetMovieOrSerieUseCase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * ViewModel responsable del flujo de películas y series conectándose a la API, además
 * de añadir las películas o series a la base de datos que el usuario añada a favoritos
 *
 * @property names lista con palabras que le pasaremos a la API para que haga la búsqueda
 * @property _moviePosition flujo de datos que mantiene la posición de la película que se va a mostrar al usuario
 * @property moviePosition estado público de la posición de la película o serie
 * @property _seriePosition flujo de datos que mantiene la posición de la serie que se va a mostrar al usuario
 * @property seriePosition estado público de la posición de la serie
 * @property _movieCounter guarda las veces que se pide una película en concreto a la API
 * @property _serieCounter guarda las veces que se pide una película en concreto a la API
 * @property _loopMovieCounter controla si ya se ha realizado una búsqueda por cada película
 * @property _loopSerieCounter controla si ya se ha realizado una búsqueda por cada serie
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

    var actualDocument = MutableStateFlow(MovieState())

    var movieOrSerieState by mutableStateOf(MovieState())
        private set

    init {
        getAllMovies()
        getAllSeries()
    }

     private fun getAllMovies(){
         viewModelScope.launch {
             val lista = mutableListOf<MovieState>()
             for (element in names){
                 _actualMovie.value = names.indexOf(element)
                 movie.value = getMovieOrSerieUseCase.invoke(element,_movieCounter.value, "Movie")
                 if (movie.value.poster != "N/A"){
                     lista.add(movie.value)
                 }
             }
             _movieList.value = lista
             _loopMovieCounter.value++
         }
     }

    private fun getAllSeries(){
        viewModelScope.launch {
            val lista = mutableListOf<MovieState>()
            for (element in names){
                _actualSerie.value = names.indexOf(element)
                serie.value = getMovieOrSerieUseCase.invoke(element,_serieCounter.value, "Serie")
                if (serie.value.poster != "N/A"){
                    lista.add(serie.value)
                }
            }
            _serieList.value = lista
            _loopSerieCounter.value++
        }
    }

    fun newMovies(){
        if (_loopMovieCounter.value == _movieList.value.size){
            _loopMovieCounter.value = 0
            _moviePosition.value = 0
            _movieCounter.value++
            getAllMovies()
        }else{
            _propertyButton.value = Property1.Default
            _moviePosition.value++
            _loopMovieCounter.value++
        }
    }

    fun newSeries(){
        if (_loopSerieCounter.value == _serieList.value.size){
            _loopSerieCounter.value = 0
            _seriePosition.value = 0
            _serieCounter.value++
            getAllSeries()
        }else{
            _propertyButton.value = Property1.Default
            _seriePosition.value++
            _loopSerieCounter.value++
        }
    }

    fun guardarPeliculaOSerie(){
        if (_propertyButton.value == Property1.Default){
            _propertyButton.value = Property1.Guardado
        }else{
            _propertyButton.value = Property1.Default
        }
    }

    fun saveMovieOrSerie(movieState: MovieState) {
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

    fun findMovieOrSerieInDatabase(id:String){

    }
}