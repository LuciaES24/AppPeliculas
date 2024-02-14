package com.lespsan543.apppeliculas.peliculas.navigation;

import java.lang.System;

/**
 * Gestiona las diferentes rutas que componen la navegación de la aplicación
 * @param route ruta a la que va a dirigirse
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "MoviesScreen", "ProfileScreen", "SearchScreen", "SeriesScreen", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$MoviesScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$ProfileScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$SearchScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$SeriesScreen;", "app_debug"})
public abstract class Routes {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Routes(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$MoviesScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes;", "()V", "app_debug"})
    public static final class MoviesScreen extends com.lespsan543.apppeliculas.peliculas.navigation.Routes {
        @org.jetbrains.annotations.NotNull
        public static final com.lespsan543.apppeliculas.peliculas.navigation.Routes.MoviesScreen INSTANCE = null;
        
        private MoviesScreen() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$SeriesScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes;", "()V", "app_debug"})
    public static final class SeriesScreen extends com.lespsan543.apppeliculas.peliculas.navigation.Routes {
        @org.jetbrains.annotations.NotNull
        public static final com.lespsan543.apppeliculas.peliculas.navigation.Routes.SeriesScreen INSTANCE = null;
        
        private SeriesScreen() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$ProfileScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes;", "()V", "app_debug"})
    public static final class ProfileScreen extends com.lespsan543.apppeliculas.peliculas.navigation.Routes {
        @org.jetbrains.annotations.NotNull
        public static final com.lespsan543.apppeliculas.peliculas.navigation.Routes.ProfileScreen INSTANCE = null;
        
        private ProfileScreen() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes$SearchScreen;", "Lcom/lespsan543/apppeliculas/peliculas/navigation/Routes;", "()V", "app_debug"})
    public static final class SearchScreen extends com.lespsan543.apppeliculas.peliculas.navigation.Routes {
        @org.jetbrains.annotations.NotNull
        public static final com.lespsan543.apppeliculas.peliculas.navigation.Routes.SearchScreen INSTANCE = null;
        
        private SearchScreen() {
            super(null);
        }
    }
}