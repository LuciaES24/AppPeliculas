package com.lespsan543.apppeliculas.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lespsan543.apppeliculas.model.APIService
import com.lespsan543.apppeliculas.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("MutableCollectionMutableState")
class MoviesViewModel @Inject constructor(private val apiService: APIService): ViewModel() {


    private val names = listOf("dragon", "hunger", "divergent", "showman", "star", "ring", "potter", "galaxy")

    private var movieCounter = 1

    var movieList by mutableStateOf(mutableListOf<MovieModel>())

    fun getMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 0..names.size){
                val movie = apiService.getMoviesData(names[i]).search!![movieCounter]
                movieList.add(movie)
                if (i == names.size){
                    movieList.clear()
                    movieCounter++
                    getMovies()
                }
            }
        }
    }
}