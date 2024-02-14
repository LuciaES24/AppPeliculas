package com.lespsan543.apppeliculas.peliculas.data.model;

import java.lang.System;

/**
 * Recoge información de películas y series
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J-\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\bH\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/data/model/SearchModel;", "", "search", "", "Lcom/lespsan543/apppeliculas/peliculas/data/model/MovieModel;", "totalResults", "", "response", "", "(Ljava/util/List;ILjava/lang/String;)V", "getResponse", "()Ljava/lang/String;", "setResponse", "(Ljava/lang/String;)V", "getSearch", "()Ljava/util/List;", "setSearch", "(Ljava/util/List;)V", "getTotalResults", "()I", "setTotalResults", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SearchModel {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "Search")
    private java.util.List<com.lespsan543.apppeliculas.peliculas.data.model.MovieModel> search;
    @com.google.gson.annotations.SerializedName(value = "totalResults")
    private int totalResults;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "Response")
    private java.lang.String response;
    
    /**
     * Recoge información de películas y series
     */
    @org.jetbrains.annotations.NotNull
    public final com.lespsan543.apppeliculas.peliculas.data.model.SearchModel copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.lespsan543.apppeliculas.peliculas.data.model.MovieModel> search, int totalResults, @org.jetbrains.annotations.NotNull
    java.lang.String response) {
        return null;
    }
    
    /**
     * Recoge información de películas y series
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Recoge información de películas y series
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Recoge información de películas y series
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public SearchModel(@org.jetbrains.annotations.NotNull
    java.util.List<com.lespsan543.apppeliculas.peliculas.data.model.MovieModel> search, int totalResults, @org.jetbrains.annotations.NotNull
    java.lang.String response) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.lespsan543.apppeliculas.peliculas.data.model.MovieModel> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.lespsan543.apppeliculas.peliculas.data.model.MovieModel> getSearch() {
        return null;
    }
    
    public final void setSearch(@org.jetbrains.annotations.NotNull
    java.util.List<com.lespsan543.apppeliculas.peliculas.data.model.MovieModel> p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getTotalResults() {
        return 0;
    }
    
    public final void setTotalResults(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getResponse() {
        return null;
    }
    
    public final void setResponse(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
}