package com.lespsan543.apppeliculas.peliculas.data

import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Interfaz que determina las operaciones que se le realizarán a la API
 */
interface RetrofitAPI {
    /**
     * Recoge información de la API
     *
     * @param url url de la API en la que queremos buscar
     *
     * @return respuesta con los resultados obtenidos
     */
    @GET
    suspend fun getData(@Url url : String) : Response<SearchModel>

}