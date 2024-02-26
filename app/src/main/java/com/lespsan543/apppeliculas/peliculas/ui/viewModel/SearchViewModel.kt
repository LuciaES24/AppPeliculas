package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lespsan543.apppeliculas.guardar.Property1
import com.lespsan543.apppeliculas.peliculas.domain.FindMoviesOrSeriesUseCase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private val findMoviesOrSeriesUseCase = FindMoviesOrSeriesUseCase()

    private var _moviesAndSeriesList = MutableStateFlow<List<MovieState>>(emptyList())
    var moviesAndSeriesList : StateFlow<List<MovieState>> = _moviesAndSeriesList.asStateFlow()

    var movieOrSerie by mutableStateOf("")
        private set

    private var _propertyButton = MutableStateFlow(Property1.Default)
    var propertyButton : StateFlow<Property1> = _propertyButton

    fun writeMovieOrSerie(movieOrSerie:String){
        this.movieOrSerie = movieOrSerie
    }

    fun findMoviesOrSeries(){
        viewModelScope.launch {
            val search = findMoviesOrSeriesUseCase.invoke(movieOrSerie = movieOrSerie)
            _moviesAndSeriesList.value = search.search
        }
    }

    fun guardarPeliculaOSerie(){
        if (_propertyButton.value == Property1.Default){
            _propertyButton.value = Property1.Guardado
        }else{
            _propertyButton.value = Property1.Default
        }
    }

    fun saveMovieOrSerie(movieState: MovieState) {
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val newMovieOrSerie = hashMapOf(
                    "title" to movieState.title,
                    "poster" to movieState.poster,
                    "id" to movieState.imdbID,
                    "type" to movieState.type,
                    "year" to movieState.year,
                    "emailUser" to email.toString()
                )
                firestore.collection("Favoritos")
                    .add(newMovieOrSerie)
                    .addOnSuccessListener {
                        guardarPeliculaOSerie()
                    }
                    .addOnFailureListener {
                        throw Exception()
                    }
            } catch (e: Exception){
                _propertyButton.value = Property1.Default
            }
        }
    }

    fun deleteMovieOrSerie(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                firestore.collection("Favoritos").document(id)
                    .delete()
                    .addOnSuccessListener {
                        guardarPeliculaOSerie()
                    }
                    .addOnFailureListener {
                        _propertyButton.value = Property1.Guardado
                        throw Exception()
                    }
            } catch (e:Exception) {
                _propertyButton.value = Property1.Guardado
            }
        }
    }
}