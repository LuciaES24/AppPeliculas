package com.lespsan543.apppeliculas.peliculas.data.model

import com.google.gson.annotations.SerializedName

/**
 * Recoge información de películas y series
 */
data class SearchModel(
    @SerializedName("Search")
    var search : List<MovieModel>,
    @SerializedName("totalResults")
    var totalResults : Int,
    @SerializedName("Response")
    var response : String
)