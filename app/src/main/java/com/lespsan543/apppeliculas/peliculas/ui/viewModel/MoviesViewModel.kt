package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lespsan543.apppeliculas.peliculas.data.APIService
import com.lespsan543.apppeliculas.peliculas.data.model.MovieModel
import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import com.lespsan543.apppeliculas.peliculas.domain.GetMovieOrSerieUseCase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@SuppressLint("MutableCollectionMutableState")
class MoviesViewModel : ViewModel() {
    private val getMovieOrSerieUseCase = GetMovieOrSerieUseCase()

    private val names = listOf("dragon", "hunger", "divergent", "showman", "star", "ring", "potter", "galaxy")

    private var movieCounter = 1

    var loopCounter = 0

    private var _movieList = MutableStateFlow<MutableList<MovieState>>(mutableListOf())
    var movieList : StateFlow<List<MovieState>> = _movieList.asStateFlow()


    init {
        getAllMovies()
    }

    fun getMovie(movieOrSerie:String, position:Int){
        viewModelScope.launch {
            val movie = getMovieOrSerieUseCase.invoke(movieOrSerie,position)
            _movieList.value.add(movie)
        }
    }

    fun getAllMovies(){
        for (i in 0 until names.size){
            getMovie(names[i], movieCounter)
        }
        loopCounter++
    }

    fun newMovies(){
        _movieList.value.clear()
        if (loopCounter == names.size){
            getAllMovies()
            movieCounter++
        }
    }
}