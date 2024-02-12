package com.lespsan543.apppeliculas.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Define la API y las consultas que se le van a realizar
 * Recoge los datos y los convierte al modelo de datos establecido
 */
@Singleton
class APIService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.omdbapi.com/?")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Recoge una lista de películas según la palabra o nombre que se le pasa
     *
     * @param pelicula nombre o palabra para buscar películas que la incluyen
     * @return modelo de datos con la información recogida de la API
     */
    suspend fun getMoviesData(pelicula:String) : SearchModel{
        return retrofit.create(RetrofitAPI::class.java).getData(retrofit.baseUrl().toString()+
                                                                        "s=$pelicula&type=movie&apikey=a01dcc60")
    }

    /**
     * Recoge una lista de series según la palabra o nombre que se le pasa
     *
     * @param serie nombre o palabra para buscar series que la incluyen
     * @return modelo de datos con la información recogida de la API
     */
    suspend fun getSeriesData(serie:String) : SearchModel{
        return retrofit.create(RetrofitAPI::class.java).getData(retrofit.baseUrl().toString()+
                "s=$serie&type=series&apikey=a01dcc60")
    }

    /**
     * Recoge una lista de películas y series que incluyen la palabra o nombre que se indica
     *
     * @param nombre nombre de la película o serie que se quiere buscar
     * @return modelo de datos con la información recogida de la API
     */
    suspend fun getMoviesOrSeries(nombre:String) : SearchModel{
        return retrofit.create(RetrofitAPI::class.java).getData(retrofit.baseUrl().toString()+
                "s=$nombre&apikey=a01dcc60")
    }
}