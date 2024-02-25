package com.lespsan543.apppeliculas.peliculas.ui.viewModel;

import java.lang.System;

/**
 * ViewModel responsable del flujo de películas y series conectándose a la API, además
 * de añadir las películas o series a la base de datos que el usuario añada a favoritos
 *
 * @property names lista con palabras que le pasaremos a la API para que haga la búsqueda
 * @property _moviePosition flujo de datos que mantiene la posición de la película que se va a mostrar al usuario
 * @property moviePosition estado público de la posición de la película o serie
 * @property _seriePosition flujo de datos que mantiene la posición de la serie que se va a mostrar al usuario
 * @property seriePosition estado público de la posición de la serie
 * @property _movieCounter guarda las veces que se pide una película en concreto a la API
 * @property _serieCounter guarda las veces que se pide una película en concreto a la API
 * @property _loopMovieCounter controla si ya se ha realizado una búsqueda por cada película
 * @property _loopSerieCounter controla si ya se ha realizado una búsqueda por cada serie
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000201J\u000e\u0010?\u001a\u00020=2\u0006\u0010>\u001a\u000201J\b\u0010@\u001a\u00020=H\u0002J\b\u0010A\u001a\u00020=H\u0002J\u0006\u0010B\u001a\u00020=J\u0006\u0010C\u001a\u00020=J\u0006\u0010D\u001a\u00020=J\u000e\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R \u00109\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$\u00a8\u0006G"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/ui/viewModel/MoviesOrSeriesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_actualMovie", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_actualSerie", "_loopMovieCounter", "_loopSerieCounter", "_movieCounter", "_movieList", "", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "_moviePosition", "_propertyButton", "Lcom/lespsan543/apppeliculas/guardar/Property1;", "_serieCounter", "_serieList", "_seriePosition", "actualDocument", "getActualDocument", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setActualDocument", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getMovieOrSerieUseCase", "Lcom/lespsan543/apppeliculas/peliculas/domain/GetMovieOrSerieUseCase;", "movie", "movieList", "Lkotlinx/coroutines/flow/StateFlow;", "getMovieList", "()Lkotlinx/coroutines/flow/StateFlow;", "setMovieList", "(Lkotlinx/coroutines/flow/StateFlow;)V", "<set-?>", "movieOrSerieState", "getMovieOrSerieState", "()Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "setMovieOrSerieState", "(Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;)V", "movieOrSerieState$delegate", "Landroidx/compose/runtime/MutableState;", "moviePosition", "getMoviePosition", "setMoviePosition", "names", "", "propertyButton", "getPropertyButton", "setPropertyButton", "serie", "serieList", "getSerieList", "setSerieList", "seriePosition", "getSeriePosition", "setSeriePosition", "deleteMovieOrSerie", "", "id", "findMovieOrSerieInDatabase", "getAllMovies", "getAllSeries", "guardarPeliculaOSerie", "newMovies", "newSeries", "saveMovieOrSerie", "movieState", "app_debug"})
public final class MoviesOrSeriesViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
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
    private kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.guardar.Property1> _propertyButton;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends com.lespsan543.apppeliculas.guardar.Property1> propertyButton;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _actualMovie;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _actualSerie;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState> actualDocument;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState movieOrSerieState$delegate = null;
    
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
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.lespsan543.apppeliculas.guardar.Property1> getPropertyButton() {
        return null;
    }
    
    public final void setPropertyButton(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends com.lespsan543.apppeliculas.guardar.Property1> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState> getActualDocument() {
        return null;
    }
    
    public final void setActualDocument(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.lespsan543.apppeliculas.peliculas.ui.states.MovieState getMovieOrSerieState() {
        return null;
    }
    
    private final void setMovieOrSerieState(com.lespsan543.apppeliculas.peliculas.ui.states.MovieState p0) {
    }
    
    private final void getAllMovies() {
    }
    
    private final void getAllSeries() {
    }
    
    public final void newMovies() {
    }
    
    public final void newSeries() {
    }
    
    public final void guardarPeliculaOSerie() {
    }
    
    public final void saveMovieOrSerie(@org.jetbrains.annotations.NotNull
    com.lespsan543.apppeliculas.peliculas.ui.states.MovieState movieState) {
    }
    
    public final void deleteMovieOrSerie(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    public final void findMovieOrSerieInDatabase(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
}