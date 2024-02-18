package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lespsan543.apppeliculas.peliculas.domain.GetMovieOrSerieUseCase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@SuppressLint("MutableCollectionMutableState")
class MoviesOrSeriesViewModel : ViewModel() {
    private val getMovieOrSerieUseCase = GetMovieOrSerieUseCase()

    private val names = listOf("dragon", "hunger", "divergent", "showman", "star", "ring", "potter", "galaxy")

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

    init {
        getAllMovies()
        getAllSeries()
    }

     private fun getAllMovies(){
         viewModelScope.launch {
             val lista = mutableListOf<MovieState>()
             for (element in names){
                 movie.value = getMovieOrSerieUseCase.invoke(element,_movieCounter.value, "Movie")
                 lista.add(movie.value)
             }
             _movieList.value = lista
             _loopMovieCounter.value++
         }
     }

    private fun getAllSeries(){
        viewModelScope.launch {
            val lista = mutableListOf<MovieState>()
            for (element in names){
                serie.value = getMovieOrSerieUseCase.invoke(element,_serieCounter.value, "Serie")
                lista.add(serie.value)
            }
            _serieList.value = lista
            _loopSerieCounter.value++
        }
    }

    fun newMovies(){
        if (_loopMovieCounter.value == names.size){
            _moviePosition.value = 0
            _movieCounter.value++
            getAllMovies()
        }else{
            _moviePosition.value++
        }
    }

    fun newSeries(){
        if (_loopSerieCounter.value == names.size){
            _seriePosition.value = 0
            _serieCounter.value++
            getAllSeries()
        }else{
            _seriePosition.value++
        }
    }
}