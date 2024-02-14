package com.lespsan543.apppeliculas.peliculas.data

import com.lespsan543.apppeliculas.peliculas.data.model.SearchModel
import com.lespsan543.apppeliculas.peliculas.data.util.Constants.API_KEY
import com.lespsan543.apppeliculas.peliculas.data.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Define la API y las consultas que se le van a realizar
 * Recoge los datos y los convierte al modelo de datos establecido
 */
class APIService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Recoge una lista de películas que incluyen la palabra o nombre que se indica
     *
     * @param pelicula nombre o palabra para buscar películas que la incluyen
     * @return objeto SearchModel con la información recogida de la API
     */
    suspend fun getMoviesData(pelicula:String) : SearchModel {
        return retrofit.create(RetrofitAPI::class.java).getData(retrofit.baseUrl().toString()+
                                                                        "?s=$pelicula&type=movie&$API_KEY")
    }

    /**
     * Recoge una lista de series que incluyen la palabra o nombre que se indica
     *
     * @param serie nombre o palabra para buscar series que la incluyen
     * @return objeto SearchModel con la información recogida de la API
     */
    suspend fun getSeriesData(serie:String) : SearchModel {
        return retrofit.create(RetrofitAPI::class.java).getData(retrofit.baseUrl().toString()+
                "?s=$serie&type=series&$API_KEY")
    }

    /**
     * Recoge una lista de películas y series que incluyen la palabra o nombre que se indica
     *
     * @param nombre nombre de la película o serie que se quiere buscar
     * @return objeto SearchModel con la información recogida de la API
     */
    suspend fun getMoviesOrSeries(nombre:String) : SearchModel {
        return retrofit.create(RetrofitAPI::class.java).getData(retrofit.baseUrl().toString()+
                "?s=$nombre&$API_KEY")
    }
}