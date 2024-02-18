package com.lespsan543.apppeliculas.peliculas.ui.states


class MovieState(
    var title : String = "",
    var year : String = "",
    var imdbID : String = "",
    var type : String = "",
    var poster : String = ""
){
    override fun toString(): String {
        return "MovieState(title='$title', year='$year', imdbID='$imdbID', type='$type', poster='$poster')"
    }
}