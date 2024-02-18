package com.lespsan543.apppeliculas.peliculas.ui.states

import kotlinx.coroutines.flow.MutableStateFlow


class SearchState(
    var search : List<MovieState> = emptyList(),
    var totalResults : Int = 0,
    var response : String = ""
)