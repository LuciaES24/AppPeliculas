package com.lespsan543.apppeliculas.peliculas.domain

import com.lespsan543.apppeliculas.peliculas.data.AppRepository
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState

class GetMovieOrSerieUseCase {
    private val appRepository = AppRepository()
    suspend operator fun invoke(movieOrSerie:String, position:Int, tipo:String) : MovieState {
        val search = appRepository.getSearchState(movieOrSerie, tipo)
        return appRepository.getMovieState(search, position)
    }
}