package com.lespsan543.apppeliculas.peliculas.domain

import com.lespsan543.apppeliculas.peliculas.data.AppRepository
import com.lespsan543.apppeliculas.peliculas.ui.states.SearchState

class FindMoviesOrSeriesUseCase {
    private val appRepository = AppRepository()
    suspend operator fun invoke(movieOrSerie:String) : SearchState {
        val search = appRepository.getFindSearchState(movieOrSerie)
        return search
    }
}