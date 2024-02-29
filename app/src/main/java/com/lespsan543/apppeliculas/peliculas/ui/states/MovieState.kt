package com.lespsan543.apppeliculas.peliculas.ui.states

/**
 * Define el modelo de datos para guardar una película o serie. Se utiliza para guardar los estados de una película o serie
 */
class MovieState(
    var title : String = "",
    var year : String = "",
    var imdbID : String = "",
    var type : String = "",
    var poster : String = "",
    var idDoc : String = ""
)