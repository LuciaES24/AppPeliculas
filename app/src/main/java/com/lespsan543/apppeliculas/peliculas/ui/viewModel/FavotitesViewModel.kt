package com.lespsan543.apppeliculas.peliculas.ui.viewModel

import android.util.Log
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

/**
 * ViewModel responsable del flujo de datos de películas y series que se añaden a favoritos
 * recogiendo la información de la base de datos
 *
 * @property auth Instancia de FirebaseAuth utilizada para obtener el usuario actual
 * @property firestore Instancia de FirebaseFirestore utilizada para operaciones en la base de datos
 * @property _favoritesList flujo de datos de las películas y series que se han añadido a favoritos
 * @property favoritesList estado público de la lista de favoritos
 * @property _selected flujo de datos que guarda si una película o serie se ha seleccionado en la UI
 * @property selected estado público del booleano si se ha seleccionado
 * @property _selectedMovieOrSerie flujo de datos que guarda la película o serie que se ha seleccionado en la UI
 * @property selectedMovieOrSerie estado público de la película o serie seleccionada
 */
class FavotitesViewModel :ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    private var _favoritesList = MutableStateFlow<List<MovieState>>(emptyList())
    var favoritesList : StateFlow<List<MovieState>> = _favoritesList.asStateFlow()

    private var _selected = MutableStateFlow(false)
    var selected : StateFlow<Boolean> = _selected

    private val _selectedMovieOrSerie = MutableStateFlow(MovieState())
    var selectedMovieOrSerie : StateFlow<MovieState> = _selectedMovieOrSerie

    fun signOut() {
        auth.signOut()
    }

    /**
     * Cambia el valor del booleano permitiendo que se muestre
     * la película o serie que se ha seleccionado
     */
    fun showSelected(){
        _selected.value = !_selected.value
    }

    /**
     * Guarda la película o serie que se ha seleccionado en la variable
     * del ViewModel
     *
     * @param movieOrSerie película o serie que se ha seleccioando
     */
    fun changeSelectedMovieOrSerie(movieOrSerie:MovieState){
        _selectedMovieOrSerie.value = movieOrSerie
    }

    /**
     * Busca todas las películas y series que se han añadido a favoritos a partir
     * del email del usuario que ha iniciado sesión
     */
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

    /**
     * Elimina la película o serie que se le indica de la base de datos de favoritos
     *
     * @param id id de la película o serie que vamos a eliminar
     */
    fun deleteMovieOrSerie(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                firestore.collection("Favoritos").document(id)
                    .delete()
                    .addOnSuccessListener {
                        Log.d("ELIMINAR OK", "Se eliminó la nota correctamente en Firestore")
                    }
                    .addOnFailureListener {
                        Log.d("ERROR AL ELIMINAR", "ERROR al eliminar una nota en Firestore")
                    }
            } catch (e: Exception) {
                Log.d("ERROR BORRAR NOTA","Error al eliminar ${e.localizedMessage} ")
            }
        }
    }
}