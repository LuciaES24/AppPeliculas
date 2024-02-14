package com.lespsan543.apppeliculas.peliculas.ui.states

import com.lespsan543.apppeliculas.peliculas.data.model.MovieModel

class SearchState(
    var search : List<MovieModel> = emptyList(),
    var totalResults : Int = 0,
    var response : String = ""
)