package com.lespsan543.apppeliculas.peliculas.ui.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/ui/viewModel/FavotitesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_favoritesList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/lespsan543/apppeliculas/peliculas/ui/states/MovieState;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "favoritesList", "Lkotlinx/coroutines/flow/StateFlow;", "getFavoritesList", "()Lkotlinx/coroutines/flow/StateFlow;", "setFavoritesList", "(Lkotlinx/coroutines/flow/StateFlow;)V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "deleteMovieOrSerie", "", "id", "", "fetchMoviesAndSeries", "app_debug"})
public final class FavotitesViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> _favoritesList;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> favoritesList;
    
    public FavotitesViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> getFavoritesList() {
        return null;
    }
    
    public final void setFavoritesList(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.lespsan543.apppeliculas.peliculas.ui.states.MovieState>> p0) {
    }
    
    public final void fetchMoviesAndSeries() {
    }
    
    public final void deleteMovieOrSerie(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
}