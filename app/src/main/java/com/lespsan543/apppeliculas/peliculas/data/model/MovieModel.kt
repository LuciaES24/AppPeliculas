package com.lespsan543.apppeliculas.peliculas.data.model

import com.google.gson.annotations.SerializedName

/**
 * Guarda y recoge información sobre una película o serie en concreto
 */
data class MovieModel (
    @SerializedName("Title")
    var title : String,
    @SerializedName("Year")
    var year : String,
    @SerializedName("imdbID")
    var imdbID : String,
    @SerializedName("Type")
    var type : String,
    @SerializedName("Poster")
    var poster : String
){
    override fun toString(): String {
        return "MovieModel(title='$title', year='$year', imdbID='$imdbID', type='$type', poster='$poster')"
    }
}