package com.lespsan543.apppeliculas.peliculas.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.lespsan543.apppeliculas.cabecera.Cabecera
import com.lespsan543.apppeliculas.cabecera.Property1
import com.lespsan543.apppeliculas.menu.Menu
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.FavotitesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScreen(navController: NavHostController, favoritesViewModel: FavotitesViewModel) {
    val favoritesList by favoritesViewModel.favoritesList.collectAsState()
    LaunchedEffect(Unit){
        favoritesViewModel.fetchMoviesAndSeries()
    }
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val width = maxWidth
        val height = maxHeight
        Scaffold(
            topBar = {
                Cabecera(
                    modifier = Modifier
                        .height(maxHeight.times(0.08f)),
                    Property1.Perfil,
                    ajustes = {}
                )
            },
            bottomBar = {
                Menu(
                    modifier = Modifier
                        .height(maxHeight.times(0.08f)),
                    home3 = { navController.navigate(Routes.MoviesScreen.route) },
                    search3 = { navController.navigate(Routes.SearchScreen.route) },
                    fav3 = { navController.navigate(Routes.ProfileScreen.route) }
                )
            },
            ) {
            Spacer(modifier = Modifier.height(maxHeight.times(0.08f)))
            LazyVerticalGrid(
                GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
            ) {
                items(favoritesList) {
                    ShowMovieOrSerie(movieOrSerie = it, maxHeight)//onItemSelected= {}
                }
            }
            Spacer(modifier = Modifier.height(maxHeight.times(0.08f)))
        }
    }
}

@Composable
fun ShowMovieOrSerie(movieOrSerie : MovieState,
                     maxHeigth : Dp
             //onItemSelected : (Superhero) -> Unit)
){
    Card(modifier = Modifier
        .fillMaxWidth()
        //.clickable { onItemSelected(superhero) }
        .padding(4.dp)
        .height(maxHeigth * 0.45f)){
        Column {
            AsyncImage(
                model = movieOrSerie.poster,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = movieOrSerie.title,
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center)
            Text(text = movieOrSerie.year,
                fontSize = 13.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun SelectedMovieOrSerie(){
    Dialog(onDismissRequest = { /*TODO*/ }) {

    }
}