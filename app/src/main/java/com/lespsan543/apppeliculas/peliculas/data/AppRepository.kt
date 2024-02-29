package com.lespsan543.apppeliculas.peliculas.data

import com.lespsan543.apppeliculas.peliculas.data.model.MovieModel
import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import com.lespsan543.apppeliculas.peliculas.ui.states.SearchState
import retrofit2.Response

/**
 * Repositorio encargado de la comunicación y transformación de datos obtenidos de la API
 *
 * @property apiService servicio del que obtenemos las funciones para acceder a la API
 */
class AppRepository {
    private val apiService = APIService()

    /**
     * Realiza una búsqueda en la API
     *
     * @param movieOrSerie título de la serie o película
     * @param tipo determina si quiere buscar una serie o película
     *
     * @return resultado de la búsqueda
     */
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

    /**
     * Hace una búsqueda de las películas y series a partir de un título
     *
     * @param movieOrSerie título a buscar
     *
     * @return resultado de la búsqueda
     */
    suspend fun getFindSearchState(movieOrSerie: String) : SearchState{
        val response : Response<SearchModel> = apiService.getMoviesOrSeries(movieOrSerie)
        return if (response.isSuccessful){
            response.body()?.toSearchState() ?: SearchState()
        }else{
            SearchState()
        }
    }

    /**
     * Obtiene una película o serie concreta dependiendo de la posición
     *
     * @param searchState búsqueda obtenida de la API
     * @param position posición de la película o serie que queremos
     *
     * @return datos de la película o serie
     */
    fun getMovieState(searchState: SearchState, position:Int): MovieState {
        return searchState.search[position]
    }

    /**
     * Función de extensión que transforma el modelo de datos al estado
     *
     * @return estado con los datos de una película o serie
     */
    private fun MovieModel.toMovieState(): MovieState {
        return MovieState(
            title = this.title,
            year = this.year,
            imdbID = this.imdbID,
            type = this.type,
            poster = this.poster
        )
    }

    /**
     * Función de extensión que transforma el modelo de datos al estado
     *
     * @return estado con los datos de una búsqueda
     */
    private fun SearchModel.toSearchState(): SearchState {
        return SearchState(
            search = this.search.map { it.toMovieState() },
            totalResults = this.totalResults,
            response = this.response
        )
    }
}