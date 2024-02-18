package com.lespsan543.apppeliculas.peliculas.data

import retrofit2.Response
import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitAPI {
    @GET
    suspend fun getData(@Url url : String) : Response<SearchModel>

}