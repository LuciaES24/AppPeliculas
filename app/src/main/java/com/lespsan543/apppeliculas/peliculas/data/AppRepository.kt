package com.lespsan543.apppeliculas.peliculas.data

import com.lespsan543.apppeliculas.peliculas.data.model.MovieModel
import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import com.lespsan543.apppeliculas.peliculas.ui.states.SearchState
import retrofit2.Response

class AppRepository {
    private val apiService = APIService()

    suspend fun getSearchState(movieOrSerie:String, tipo:String): SearchState {
        val response: Response<SearchModel> = if (tipo == "Movie"){
            apiService.getMoviesData(movieOrSerie)
        }else{
            apiService.getSeriesData(movieOrSerie)
        }
        return if (response.isSuccessful) {
            response.body()?.toSearchState() ?: SearchState()
        } else {
            SearchState()
        }
    }

    suspend fun getFindSearchState(movieOrSerie: String) : SearchState{
        val response : Response<SearchModel> = apiService.getMoviesOrSeries(movieOrSerie)
        return if (response.isSuccessful){
            response.body()?.toSearchState() ?: SearchState()
        }else{
            SearchState()
        }
    }

    fun getMovieState(searchState: SearchState, position:Int): MovieState {
        return searchState.search[position]
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
            search = this.search.map { it.toMovieState() },
            totalResults = this.totalResults,
            response = this.response
        )
    }
}