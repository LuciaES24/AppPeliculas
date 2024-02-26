package com.lespsan543.apppeliculas.peliculas.ui.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\u000e\u0010&\u001a\u00020\"2\u0006\u0010\'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d\u00a8\u0006)"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/ui/viewModel/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_moviesAndSeriesList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "_propertyButton", "Lcom/lespsan543/apppeliculas/guardar/Property1;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "findMoviesOrSeriesUseCase", "Lcom/lespsan543/apppeliculas/peliculas/domain/FindMoviesOrSeriesUseCase;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "<set-?>", "", "movieOrSerie", "getMovieOrSerie", "()Ljava/lang/String;", "setMovieOrSerie", "(Ljava/lang/String;)V", "movieOrSerie$delegate", "Landroidx/compose/runtime/MutableState;", "moviesAndSeriesList", "Lkotlinx/coroutines/flow/StateFlow;", "getMoviesAndSeriesList", "()Lkotlinx/coroutines/flow/StateFlow;", "setMoviesAndSeriesList", "(Lkotlinx/coroutines/flow/StateFlow;)V", "propertyButton", "getPropertyButton", "setPropertyButton", "deleteMovieOrSerie", "", "id", "findMoviesOrSeries", "guardarPeliculaOSerie", "saveMovieOrSerie", "movieState", "writeMovieOrSerie", "app_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    private final com.lespsan543.apppeliculas.peliculas.domain.FindMoviesOrSeriesUseCase findMoviesOrSeriesUseCase = null;
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> _moviesAndSeriesList;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> moviesAndSeriesList;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState movieOrSerie$delegate = null;
    private kotlinx.coroutines.flow.MutableStateFlow<com.lespsan543.apppeliculas.guardar.Property1> _propertyButton;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends com.lespsan543.apppeliculas.guardar.Property1> propertyButton;
    
    public SearchViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> getMoviesAndSeriesList() {
        return null;
    }
    
    public final void setMoviesAndSeriesList(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMovieOrSerie() {
        return null;
    }
    
    private final void setMovieOrSerie(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.lespsan543.apppeliculas.guardar.Property1> getPropertyButton() {
        return null;
    }
    
    public final void setPropertyButton(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends com.lespsan543.apppeliculas.guardar.Property1> p0) {
    }
    
    public final void writeMovieOrSerie(@org.jetbrains.annotations.NotNull
    java.lang.String movieOrSerie) {
    }
    
    public final void findMoviesOrSeries() {
    }
    
    public final void guardarPeliculaOSerie() {
    }
    
    public final void saveMovieOrSerie(@org.jetbrains.annotations.NotNull
    com.lespsan543.apppeliculas.peliculas.ui.states.MovieState movieState) {
    }
    
    public final void deleteMovieOrSerie(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
}