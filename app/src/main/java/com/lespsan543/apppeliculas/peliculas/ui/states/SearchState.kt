package com.lespsan543.apppeliculas.peliculas.ui.states

/**
 * Define el modelo de datos para guardar una búsqueda. Se utiliza para extraer guardar los estados de una búsqueda
 */
class SearchState(
    var search : List<MovieState> = emptyList(),
    var totalResults : Int = 0,
    var response : String = ""
)