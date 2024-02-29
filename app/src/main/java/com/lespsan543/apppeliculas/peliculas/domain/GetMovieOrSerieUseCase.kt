package com.lespsan543.apppeliculas.peliculas.domain

import com.lespsan543.apppeliculas.peliculas.data.AppRepository
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState

/**
 * Caso de uso que conecta las distintas capas de la aplicación permitiendo buscar una película o serie en concreto
 *
 * @property appRepository repositorio del que obtenemos la información de la API
 */
class GetMovieOrSerieUseCase {
    private val appRepository = AppRepository()

    /**
     * Invoca la función del repositorio que extrae información sobre una película o serie
     *
     * @param movieOrSerie título que queremos buscar
     * @param position posición en la lista de dicho título
     * @param tipo determina si es película o serie
     *
     * @return objeto con la información de la película o serie
     */
    suspend operator fun invoke(movieOrSerie:String, position:Int, tipo:String) : MovieState {
        val search = appRepository.getSearchState(movieOrSerie, tipo)
        return appRepository.getMovieState(search, position)
    }
}