package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class FavotitesViewModel :ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private var _favoritesList = MutableStateFlow<List<MovieState>>(emptyList())
    var favoritesList : StateFlow<List<MovieState>> = _favoritesList.asStateFlow()

    fun fetchMoviesAndSeries() {
        val email = auth.currentUser?.email
        firestore.collection("Favoritos")
            .whereEqualTo("emailUser", email.toString())
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val favorites = mutableListOf<MovieState>()
                if (querySnapshot != null) {
                    for (document in querySnapshot) {
                        val movieOrSerie = document.toObject(MovieState::class.java)
                        movieOrSerie.idDoc = document.id
                        favorites.add(movieOrSerie)
                    }
                }
                _favoritesList.value = favorites
            }
    }

    fun deleteMovieOrSerie(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                firestore.collection("Favoritos").document(id)
                    .delete()
                    .addOnSuccessListener {
                        //guardarPeliculaOSerie()
                    }
                    .addOnFailureListener {
                        //_propertyButton.value = Property1.Guardado
                        throw Exception()
                    }
            } catch (e: Exception) {
                //_propertyButton.value = Property1.Guardado
            }
        }
    }
}