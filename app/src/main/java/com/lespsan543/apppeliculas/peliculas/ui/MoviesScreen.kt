package com.lespsan543.apppeliculas.peliculas.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.lespsan543.apppeliculas.guardar.Guardar
import com.lespsan543.apppeliculas.menu.Menu
import com.lespsan543.apppeliculas.menu.Property1
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.MoviesOrSeriesViewModel

@Composable
fun MoviesScreen(
    navController: NavHostController,
    moviesOrSeriesViewModel: MoviesOrSeriesViewModel,
) {
    ShowMovies(navController = navController,
        moviesOrSeriesViewModel = moviesOrSeriesViewModel)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowMovies(
    navController: NavHostController,
    moviesOrSeriesViewModel: MoviesOrSeriesViewModel
) {
    val moviePosition by moviesOrSeriesViewModel.moviePosition.collectAsState()
    val movieList by moviesOrSeriesViewModel.movieList.collectAsState()
    val property by moviesOrSeriesViewModel.propertyButton.collectAsState()

    LaunchedEffect(Unit){
        moviesOrSeriesViewModel.getAllMovies()
    }
    LaunchedEffect(Unit){
        moviesOrSeriesViewModel.fetchMoviesInDB()
    }
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val width = maxWidth
        val height = maxHeight
        Scaffold(
            bottomBar = { Menu(modifier = Modifier.height(maxHeight.times(0.08f)),
                property1 = Property1.Inicio,
                home = { navController.navigate(Routes.MoviesScreen.route) },
                fav1 = { navController.navigate(Routes.ProfileScreen.route) },
                search = { navController.navigate(Routes.SearchScreen.route) }) },
            floatingActionButton = {
                Row {
                    FloatingActionButton(onClick = { navController.navigate(Routes.MoviesScreen.route) },
                        modifier = Modifier
                            .width(width.times(0.25f))
                            .height(height.times(0.05f)),
                        containerColor = Color(40,40,40),
                        shape = RectangleShape) {
                        Text(text = "Películas", color = Color.White, fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    FloatingActionButton(onClick = { navController.navigate(Routes.SeriesScreen.route) },
                        modifier = Modifier
                            .width(width.times(0.25f))
                            .height(height.times(0.05f)),
                        containerColor = Color(85,85,85),
                        shape = RectangleShape
                    ) {
                        Text(text = "Series", color = Color.White, fontSize = 16.sp)
                    }
                }
            }
        ) {
            //Aparece si la información de la API ya ha sido cargada
            if (movieList.isNotEmpty()){
                //Miramos si la película ya está guardada en la base de datos
                moviesOrSeriesViewModel.findMovieInList(movieList[moviePosition].title)
                Column(horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black))
                {
                    ExtendedFloatingActionButton(onClick = { moviesOrSeriesViewModel.newMovies()
                        moviesOrSeriesViewModel.findMovieInList(movieList[moviePosition].title)
                    },
                        modifier = Modifier
                            .fillMaxSize()
                            .width(width * 0.5f),
                        containerColor = Color.Transparent
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
                    }
                }
                AsyncImage(model = movieList[moviePosition].poster,
                    contentDescription = "Poster película",
                    modifier = Modifier
                        .height(height)
                        .width(width)
                )
                Guardar(
                    modifier = Modifier
                        .padding(start = width*0.10f, top = height*0.85f),
                    property1 = property,
                    guardar = { moviesOrSeriesViewModel.saveMovieOrSerie(movieList[moviePosition]) },
                    eliminar = { moviesOrSeriesViewModel.deleteMovieOrSerie(movieList[moviePosition].idDoc) }
                )
            }else{
                //Aparece si aún no ha cargado la información de la API
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(height * 0.5f)
                            .width(width * 0.5f)
                    )
                }
            }
        }
    }
}