package com.lespsan543.apppeliculas.peliculas.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.lespsan543.apppeliculas.peliculas.data.util.Constants.FONT_FAMILY
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.FavotitesViewModel

/**
 * Muestra la pantalla de favoritos, donde se encuentran todas las películas y series que ha añadido el usuario
 *
 * @param navController nos permite realizar la navegación entre pantallas
 * @param favoritesViewModel viewModel del que obtendremos los datos
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScreen(navController: NavHostController, favoritesViewModel: FavotitesViewModel) {
    //Lista de películas y series que el usuario ha añadido a favoritos
    val favoritesList by favoritesViewModel.favoritesList.collectAsState()
    //Booleano que determina si se ha pulsado sobre un elemento
    val showSelected by favoritesViewModel.selected.collectAsState()

    LaunchedEffect(Unit){
        favoritesViewModel.fetchMoviesAndSeries()
    }
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                Cabecera(
                    modifier = Modifier
                        .height(maxHeight.times(0.08f)),
                    Property1.Perfil,
                    salir = { favoritesViewModel.signOut()
                              navController.navigate(Routes.LogInScreen.route)}
                )
            },
            bottomBar = {
                Menu(
                    modifier = Modifier
                        .height(maxHeight.times(0.08f)),
                    home3 = { navController.navigate(Routes.MoviesScreen.route) },
                    search3 = { navController.navigate(Routes.SearchScreen.route) },
                    fav3 = { navController.navigate(Routes.ProfileScreen.route) },
                    property1 = com.lespsan543.apppeliculas.menu.Property1.Perfil
                )
            },
            ) {
            //Se muestra si hay algún elemento en la lista de favoritos
            if(favoritesList.isNotEmpty()){
                Spacer(modifier = Modifier.height(maxHeight.times(0.08f)))
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(199, 199, 199))
                        .padding(top = maxHeight * 0.08f, bottom = maxHeight * 0.08f)
                ) {
                    items(favoritesList) {movieOrSerie ->
                        ShowMovieOrSerie(movieOrSerie = movieOrSerie,
                            maxHeight,
                            selectedMovieOrSerie = { favoritesViewModel.showSelected()
                                                    favoritesViewModel.changeSelectedMovieOrSerie(movieOrSerie)})
                        if (showSelected){
                            SelectedMovieOrSerie(
                                height = maxHeight,
                                width = maxWidth,
                                favoritesViewModel = favoritesViewModel
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(maxHeight.times(0.08f)))
            }//Se muestra si el usuario aún no ha añadido nada a favoritos
            else{
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(199, 199, 199))
                        .padding(top = maxHeight * 0.08f, bottom = maxHeight * 0.08f)
                ) {
                    Text(text = "Aún no tienes nada en favoritos",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontFamily = FONT_FAMILY
                    )
                }
            }
        }
    }
}

/**
 * Muestra una película o serie mostrando la imagen, su título y el año de estreno
 *
 * @param movieOrSerie película o serie
 * @param maxHeigth altura de la pantalla
 * @param selectedMovieOrSerie determina que ocurre cuando se pulsa sobre el elemento
 */
@Composable
fun ShowMovieOrSerie(movieOrSerie : MovieState,
                     maxHeigth : Dp,
                    selectedMovieOrSerie : (MovieState) -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { selectedMovieOrSerie(movieOrSerie) }
        .padding(4.dp)
        .height(maxHeigth * 0.47f)
        .background(Color.Transparent)){
        Column(modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()) {
            AsyncImage(
                model = movieOrSerie.poster,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = movieOrSerie.title,
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontFamily = FONT_FAMILY
            )
            Text(text = movieOrSerie.year,
                fontSize = 13.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
                fontFamily = FONT_FAMILY
            )
        }
    }
}

/**
 * Muestra una película o serie cuando se ha pulsado sobre ella
 *
 * @param height altura de la pantalla
 * @param width ancho de la pantalla
 * @param favoritesViewModel viewModel responsable de los datos de la pantalla
 *
 * @property movieOrSerie película o serie que se ha seleccionado
 */
@Composable
fun SelectedMovieOrSerie(height : Dp,
                         width :Dp,
                         favoritesViewModel: FavotitesViewModel){
    val movieOrSerie by favoritesViewModel.selectedMovieOrSerie.collectAsState()
    Dialog(onDismissRequest = { favoritesViewModel.showSelected() }) {
        Column(modifier = Modifier
            .height(height * 0.9f)
            .background(Color(199, 199, 199))
            .padding(top = height * 0.1f),
            horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = movieOrSerie.poster,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(height * 0.01f))
            Text(text = movieOrSerie.title,
                fontFamily = FONT_FAMILY,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(height * 0.03f))
            Text(text = movieOrSerie.year,
                fontFamily = FONT_FAMILY,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(height * 0.035f))
            IconButton(onClick = { favoritesViewModel.deleteMovieOrSerie(movieOrSerie.idDoc)
                                    favoritesViewModel.showSelected()},
                modifier = Modifier.padding(start = width*0.5f)) {
                Icon(imageVector = Icons.Filled.Delete , contentDescription = null, tint = Color.Black)
            }
        }
    }
}