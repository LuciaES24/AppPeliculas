package com.lespsan543.apppeliculas.peliculas.ui.viewModel;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MutableCollectionMutableState"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0006\u0010\'\u001a\u00020%J\u0006\u0010(\u001a\u00020%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/ui/viewModel/MoviesOrSeriesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_loopMovieCounter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_loopSerieCounter", "_movieCounter", "_movieList", "", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "_moviePosition", "_serieCounter", "_serieList", "_seriePosition", "getMovieOrSerieUseCase", "Lcom/lespsan543/apppeliculas/peliculas/domain/GetMovieOrSerieUseCase;", "movie", "movieList", "Lkotlinx/coroutines/flow/StateFlow;", "getMovieList", "()Lkotlinx/coroutines/flow/StateFlow;", "setMovieList", "(Lkotlinx/coroutines/flow/StateFlow;)V", "moviePosition", "getMoviePosition", "setMoviePosition", "names", "", "serie", "serieList", "getSerieList", "setSerieList", "seriePosition", "getSeriePosition", "setSeriePosition", "getAllMovies", "", "getAllSeries", "newMovies", "newSeries", "app_debug"})
public final class MoviesOrSeriesViewModel extends androidx.lifecycle.ViewModel {
    private final com.lespsan543.apppeliculas.peliculas.domain.GetMovieOrSerieUseCase getMovieOrSerieUseCase = null;
    private final java.util.List<java.lang.String> names = null;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _moviePosition;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<java.lang.Integer> moviePosition;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _seriePosition;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<java.lang.Integer> seriePosition;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _movieCounter;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _serieCounter;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _loopMovieCounter;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _loopSerieCounter;
    private kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState> movie;
    private kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState> serie;
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> _movieList;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> movieList;
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> _serieList;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> serieList;
    
    public MoviesOrSeriesViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getMoviePosition() {
        return null;
    }
    
    public final void setMoviePosition(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSeriePosition() {
        return null;
    }
    
    public final void setSeriePosition(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> getMovieList() {
        return null;
    }
    
    public final void setMovieList(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> getSerieList() {
        return null;
    }
    
    public final void setSerieList(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> p0) {
    }
    
    private final void getAllMovies() {
    }
    
    private final void getAllSeries() {
    }
    
    public final void newMovies() {
    }
    
    public final void newSeries() {
    }
}