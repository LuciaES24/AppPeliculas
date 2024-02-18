package com.lespsan543.apppeliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.MoviesScreen
import com.lespsan543.apppeliculas.peliculas.ui.SeriesScreen
import com.lespsan543.apppeliculas.ui.theme.AppPeliculasTheme
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.MoviesOrSeriesViewModel
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.ProfileViewModel
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.SearchViewModel

class MainActivity : ComponentActivity() {
    private val moviesOrSeriesViewModel : MoviesOrSeriesViewModel by viewModels()
    private val profileViewModel : ProfileViewModel by viewModels()
    private val searchViewModel : SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPeliculasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.MoviesScreen.route) {
                        composable(Routes.MoviesScreen.route) {
                            MoviesScreen(navController, moviesOrSeriesViewModel)
                        }
                        composable(Routes.SeriesScreen.route) {
                            SeriesScreen(navController, moviesOrSeriesViewModel)
                        }

                    }
                }
            }
        }
    }
}