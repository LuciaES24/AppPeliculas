package com.lespsan543.apppeliculas.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.lespsan543.apppeliculas.menu.Menu
import com.lespsan543.apppeliculas.menu.Property1
import com.lespsan543.apppeliculas.navigation.Routes
import com.lespsan543.apppeliculas.viewModel.MoviesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(navController: NavHostController, moviesViewModel: MoviesViewModel) {
    Scaffold(
        bottomBar = { Menu(property1 = Property1.Inicio,
            home = { navController.navigate(Routes.MoviesScreen.route) },
            profile = { navController.navigate(Routes.ProfileScreen.route) },
            search = { navController.navigate(Routes.SearchScreen.route) }) }
    ) {
        Column {

        }
    }
}