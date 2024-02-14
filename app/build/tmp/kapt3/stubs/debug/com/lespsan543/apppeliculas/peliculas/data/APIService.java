package com.lespsan543.apppeliculas.peliculas.data;

import java.lang.System;

/**
 * Define la API y las consultas que se le van a realizar
 * Recoge los datos y los convierte al modelo de datos establecido
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/data/APIService;", "", "()V", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getMoviesData", "Lcom/lespsan543/apppeliculas/peliculas/data/model/SearchModel;", "pelicula", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesOrSeries", "nombre", "getSeriesData", "serie", "app_debug"})
public final class APIService {
    private final retrofit2.Retrofit retrofit = null;
    
    public APIService() {
        super();
    }
    
    /**
     * Recoge una lista de películas que incluyen la palabra o nombre que se indica
     *
     * @param pelicula nombre o palabra para buscar películas que la incluyen
     * @return objeto SearchModel con la información recogida de la API
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMoviesData(@org.jetbrains.annotations.NotNull
    java.lang.String pelicula, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.lespsan543.apppeliculas.peliculas.data.model.SearchModel> continuation) {
        return null;
    }
    
    /**
     * Recoge una lista de series que incluyen la palabra o nombre que se indica
     *
     * @param serie nombre o palabra para buscar series que la incluyen
     * @return objeto SearchModel con la información recogida de la API
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSeriesData(@org.jetbrains.annotations.NotNull
    java.lang.String serie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.lespsan543.apppeliculas.peliculas.data.model.SearchModel> continuation) {
        return null;
    }
    
    /**
     * Recoge una lista de películas y series que incluyen la palabra o nombre que se indica
     *
     * @param nombre nombre de la película o serie que se quiere buscar
     * @return objeto SearchModel con la información recogida de la API
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMoviesOrSeries(@org.jetbrains.annotations.NotNull
    java.lang.String nombre, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.lespsan543.apppeliculas.peliculas.data.model.SearchModel> continuation) {
        return null;
    }
}