package com.lespsan543.apppeliculas.peliculas.domain

import com.lespsan543.apppeliculas.peliculas.data.AppRepository
import com.lespsan543.apppeliculas.peliculas.ui.states.SearchState

/**
 * Caso de uso que conecta las distintas capas de la aplicación permitiendo buscar una lista de
 * películas y series a partir de un título
 *
 * @property appRepository repositorio del que obtenemos la información de la API
 */
class FindMoviesOrSeriesUseCase {
    private val appRepository = AppRepository()

    /**
     * Invoca la función del repositorio que extrae la lista de películas y series
     *
     * @param movieOrSerie título que queremos buscar
     *
     * @return objeto con la información de la búsqueda
     */
    suspend operator fun invoke(movieOrSerie:String) : SearchState {
        val search = appRepository.getFindSearchState(movieOrSerie)
        return search
    }
}