package com.lespsan543.apppeliculas.peliculas.ui.viewModel;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MutableCollectionMutableState"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/ui/viewModel/MoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_movieList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "getMovieOrSerieUseCase", "Lcom/lespsan543/apppeliculas/peliculas/domain/GetMovieOrSerieUseCase;", "loopCounter", "", "getLoopCounter", "()I", "setLoopCounter", "(I)V", "movieCounter", "movieList", "Lkotlinx/coroutines/flow/StateFlow;", "", "getMovieList", "()Lkotlinx/coroutines/flow/StateFlow;", "setMovieList", "(Lkotlinx/coroutines/flow/StateFlow;)V", "names", "", "getAllMovies", "", "getMovie", "movieOrSerie", "position", "newMovies", "app_debug"})
public final class MoviesViewModel extends androidx.lifecycle.ViewModel {
    private final com.lespsan543.apppeliculas.peliculas.domain.GetMovieOrSerieUseCase getMovieOrSerieUseCase = null;
    private final java.util.List<java.lang.String> names = null;
    private int movieCounter = 1;
    private int loopCounter = 0;
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> _movieList;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> movieList;
    
    public MoviesViewModel() {
        super();
    }
    
    public final int getLoopCounter() {
        return 0;
    }
    
    public final void setLoopCounter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> p0) {
    }
    
    public final void getMovie(@org.jetbrains.annotations.NotNull
    java.lang.String movieOrSerie, int position) {
    }
    
    public final void getAllMovies() {
    }
    
    public final void newMovies() {
    }
}