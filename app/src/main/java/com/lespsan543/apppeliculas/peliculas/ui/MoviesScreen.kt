package com.lespsan543.apppeliculas.peliculas.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.lespsan543.apppeliculas.menu.Menu
import com.lespsan543.apppeliculas.menu.Property1
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.MoviesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(navController: NavHostController, moviesViewModel: MoviesViewModel) {
    var loopCounter = moviesViewModel.loopCounter
    val movieList by moviesViewModel.movieList.collectAsState()
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Scaffold(
        bottomBar = { Menu(modifier = Modifier.height(70.dp),
            property1 = Property1.Inicio,
            home = { navController.navigate(Routes.MoviesScreen.route) },
            profile = { navController.navigate(Routes.ProfileScreen.route) },
            search = { navController.navigate(Routes.SearchScreen.route) }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            for (i in 0 until movieList.size){
                Text(text = movieList[i].toString())
                Log.d("moviess",movieList[i].toString())
            }
        }
    }
}