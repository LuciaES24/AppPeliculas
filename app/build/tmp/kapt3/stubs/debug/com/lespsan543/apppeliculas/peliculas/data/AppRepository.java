package com.lespsan543.apppeliculas.peliculas.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0011H\u0002J\f\u0010\u0012\u001a\u00020\b*\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/data/AppRepository;", "", "()V", "apiService", "Lcom/lespsan543/apppeliculas/peliculas/data/APIService;", "getMovieState", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "searchState", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/SearchState;", "position", "", "(Lcom/lespsan543/apppeliculas/peliculas/ui/states/SearchState;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchState", "movieOrSerie", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMovieState", "Lcom/lespsan543/apppeliculas/peliculas/data/model/MovieModel;", "toSearchState", "Lcom/lespsan543/apppeliculas/peliculas/data/model/SearchModel;", "app_debug"})
public final class AppRepository {
    private final com.lespsan543.apppeliculas.peliculas.data.APIService apiService = null;
    
    public AppRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSearchState(@org.jetbrains.annotations.NotNull
    java.lang.String movieOrSerie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.lespsan543.apppeliculas.peliculas.ui.states.SearchState> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMovieState(@org.jetbrains.annotations.NotNull
    com.lespsan543.apppeliculas.peliculas.ui.states.SearchState searchState, int position, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.lespsan543.apppeliculas.peliculas.ui.states.MovieState> continuation) {
        return null;
    }
    
    private final com.lespsan543.apppeliculas.peliculas.ui.states.MovieState toMovieState(com.lespsan543.apppeliculas.peliculas.data.model.MovieModel $this$toMovieState) {
        return null;
    }
    
    private final com.lespsan543.apppeliculas.peliculas.ui.states.SearchState toSearchState(com.lespsan543.apppeliculas.peliculas.data.model.SearchModel $this$toSearchState) {
        return null;
    }
}