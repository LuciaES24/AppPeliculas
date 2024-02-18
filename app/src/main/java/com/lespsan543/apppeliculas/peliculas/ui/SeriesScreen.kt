package com.lespsan543.apppeliculas.peliculas.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
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
import com.lespsan543.apppeliculas.menu.Menu
import com.lespsan543.apppeliculas.menu.Property1
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.MoviesOrSeriesViewModel

@Composable
fun SeriesScreen(
    navController: NavHostController,
    moviesOrSeriesViewModel: MoviesOrSeriesViewModel,
){
    ShowSeries(navController = navController,
        moviesOrSeriesViewModel = moviesOrSeriesViewModel)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowSeries(
    navController: NavHostController,
    moviesOrSeriesViewModel: MoviesOrSeriesViewModel
) {
    val seriePosition by moviesOrSeriesViewModel.seriePosition.collectAsState()
    val serieList by moviesOrSeriesViewModel.serieList.collectAsState()
    BoxWithConstraints {
        val width = maxWidth
        val height = maxHeight
        Scaffold(
            bottomBar = { Menu(modifier = Modifier.height(maxHeight.times(0.10f)),
                property1 = Property1.Inicio,
                home = { navController.navigate(Routes.MoviesScreen.route) },
                profile = { navController.navigate(Routes.ProfileScreen.route) },
                search = { navController.navigate(Routes.SearchScreen.route) }) },
            floatingActionButton = {
                Row {
                    FloatingActionButton(onClick = { navController.navigate(Routes.MoviesScreen.route) },
                        modifier = Modifier
                            .width(width.times(0.25f))
                            .height(height.times(0.05f)),
                        containerColor = Color(40,40,40),
                        shape = RectangleShape
                    ) {
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
            if (serieList.isNotEmpty()){
                //Aparece si la información de la API ya ha sido cargada
                AsyncImage(model = serieList[seriePosition].poster,
                    contentDescription = "Poster película",
                    modifier = Modifier
                        .height(height)
                        .width(width)
                )
                ExtendedFloatingActionButton(onClick = { moviesOrSeriesViewModel.newSeries()},
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width * 0.5f),
                    containerColor = Color.Transparent
                ) {
                    Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
                }
            }else{
                //Aparece si aún no ha cargado la información de la API
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(height * 0.5f)
                            .width(width * 0.5f),)
                }
            }
        }
    }
}