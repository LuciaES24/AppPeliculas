package com.lespsan543.apppeliculas.peliculas.data

import com.lespsan543.apppeliculas.peliculas.data.model.MovieModel
import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import com.lespsan543.apppeliculas.peliculas.ui.states.SearchState

class AppRepository {
    private val apiService = APIService()

    suspend fun getSearchState(movieOrSerie:String): SearchState {
        val response = apiService.getMoviesData(movieOrSerie)
        return if (response.response == "True") {
            response.toSearchState() ?: SearchState()
        } else {
            SearchState()
        }
    }

    suspend fun getMovieState(searchState: SearchState, position:Int): MovieState {
        return if (searchState.response == "True") {
            searchState.search[position].toMovieState() ?: MovieState()
        } else {
            MovieState()
        }
    }

    private fun MovieModel.toMovieState(): MovieState {
        return MovieState(
            title = this.title,
            year = this.year,
            imdbID = this.imdbID,
            type = this.type,
            poster = this.poster
        )
    }

    private fun SearchModel.toSearchState(): SearchState {
        return SearchState(
            search = this.search,
            totalResults = this.totalResults,
            response = this.response
        )
    }
}