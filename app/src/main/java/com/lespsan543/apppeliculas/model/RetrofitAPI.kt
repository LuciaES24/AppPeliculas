package com.lespsan543.apppeliculas.model

import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitAPI {
    @GET
    suspend fun getData(@Url url : String) : SearchModel

}