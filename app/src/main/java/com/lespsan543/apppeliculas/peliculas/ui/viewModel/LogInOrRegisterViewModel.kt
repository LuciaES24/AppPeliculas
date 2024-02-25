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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class LogInOrRegisterViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore

    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var name by mutableStateOf("")
        private set

    private var _wrong = MutableStateFlow(false)
    var wrong : StateFlow<Boolean> = _wrong

    fun createUser(onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            saveUser(name)
                            onSuccess()
                        } else {
                            throw Exception()
                        }
                    }
            } catch (e: Exception){
                _wrong.value = true
            }
        }
    }

    private fun saveUser(username: String){
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            val user = hashMapOf(
                "id" to id.toString(),
                "email" to email.toString(),
                "name" to username,
                "password" to password
            )
            firestore.collection("Users")
                .add(user)
        }
    }

    fun logIn(onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { log ->
                        if (log.isSuccessful) {
                            onSuccess()
                        } else {
                            _wrong.value = true
                            throw Exception()
                        }
                    }
                reset()
            } catch (e: Exception){
                _wrong.value = true
            }
        }
    }

    private fun reset(){
        email = ""
        name = ""
        email = ""
    }

    fun closeDialog(){
        _wrong.value = false
    }

    fun writeEmail(email:String){
        this.email = email
    }

    fun writeName(name:String){
        this.name = name
    }

    fun writePassword(password:String){
        this.password = password
    }
}