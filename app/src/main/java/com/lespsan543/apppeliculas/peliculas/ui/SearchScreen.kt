package com.lespsan543.apppeliculas.peliculas.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.lespsan543.apppeliculas.cabecera.Cabecera
import com.lespsan543.apppeliculas.cabecera.Property1
import com.lespsan543.apppeliculas.guardar.Guardar
import com.lespsan543.apppeliculas.menu.Menu
import com.lespsan543.apppeliculas.peliculas.data.util.Constants.FONT_FAMILY
import com.lespsan543.apppeliculas.peliculas.navigation.Routes
import com.lespsan543.apppeliculas.peliculas.ui.states.MovieState
import com.lespsan543.apppeliculas.peliculas.ui.viewModel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController, searchViewModel: SearchViewModel){
    val findList by searchViewModel.moviesAndSeriesList.collectAsState()
    val movieOrSerie = searchViewModel.movieOrSerie
    val listOfPropertyButtons = searchViewModel.listOfPropertyButtons

    LaunchedEffect(Unit){
        searchViewModel.fetchMoviesInDB()
    }
    BoxWithConstraints {
        val height = maxHeight
        val width = maxWidth
        Scaffold(
            topBar = {
                Cabecera(
                    modifier = Modifier
                        .height(maxHeight.times(0.08f)),
                    Property1.BuscarPeli
                )
            },
            bottomBar = {
                Menu(
                    modifier = Modifier
                        .height(maxHeight.times(0.08f)),
                    home2 = { navController.navigate(Routes.MoviesScreen.route) },
                    search2 = { navController.navigate(Routes.SearchScreen.route) },
                    fav2 = { navController.navigate(Routes.ProfileScreen.route) },
                    property1 = com.lespsan543.apppeliculas.menu.Property1.Buscar
                )
            }
        ) {
            if (findList.isEmpty()){
                //Si aún no se ha realizado la búsqueda
                Column (modifier = Modifier
                    .background(Color(199, 199, 199))
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(height.times(0.15f)))
                    TextField(value = movieOrSerie,
                        onValueChange = { searchViewModel.writeMovieOrSerie(it) },
                        label = { Text(text = "Nombre...", color = Color.White, fontFamily = FONT_FAMILY) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            containerColor = Color(40,40,40),
                            textColor = Color.White
                        ),
                        singleLine = true,
                        trailingIcon = {
                            if (movieOrSerie.isNotBlank())
                                IconButton(onClick = { searchViewModel.findMoviesOrSeries()
                                                        searchViewModel.resetMovieOrSerie()})
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Search,
                                        contentDescription = "Buscar"
                                    )
                                }
                        }
                    )
                    Spacer(modifier = Modifier.height(height * 0.1f))
                    Text(text = "Encuentra la película o serie que quieras",
                        fontSize = 16.sp,
                        fontFamily = FONT_FAMILY,
                        color = Color.Black
                    )
                }
            }//Si la lista aún no se ha generado, aparece cargando
            else if(listOfPropertyButtons.isEmpty()){
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
            else{
                //Si se ha encontrado el resultado
                Column(modifier = Modifier
                    .padding(top = height * 0.08f, bottom = height * 0.08f)
                    .background(Color(199, 199, 199)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(height.times(0.03f)))
                    TextField(value = movieOrSerie,
                        onValueChange = { searchViewModel.writeMovieOrSerie(it) },
                        label = { Text(text = "Nombre...", color = Color.White, fontFamily = FONT_FAMILY) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            containerColor = Color(40,40,40),
                            textColor = Color.White
                        ),
                        singleLine = true,
                        trailingIcon = {
                            if (movieOrSerie.isNotBlank())
                                IconButton(onClick = { searchViewModel.findMoviesOrSeries()
                                    searchViewModel.resetMovieOrSerie()
                                    searchViewModel.generatePropertyButtons()})
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Search,
                                        contentDescription = "Buscar"
                                    )
                                }
                        }
                    )
                    Spacer(modifier = Modifier.height(height.times(0.03f)))
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
                    ) {
                        items(findList) {
                            ShowMovieOrSerie(height = height,
                                index = findList.indexOf(it),
                                movieOrSerie = it,
                                searchViewModel = searchViewModel)
                            Spacer(modifier = Modifier.height(height * 0.01f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowMovieOrSerie(height: Dp,
                     index:Int,
                     movieOrSerie:MovieState,
                     searchViewModel: SearchViewModel){
    val listOfPropertyButtons = searchViewModel.listOfPropertyButtons
    val movieOrSerieIndex = searchViewModel.findInList(movieOrSerie)
    BoxWithConstraints {
        val widthCard = maxWidth
        Box(
            modifier = Modifier
                .height(height * 0.3f)
                .fillMaxWidth()
                .background(Color(40, 40, 40))
        ) {
            Row {
                AsyncImage(model = movieOrSerie.poster,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(widthCard * 0.5f))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = movieOrSerie.title,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontFamily = FONT_FAMILY,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(height * 0.03f))
                    Text(text = movieOrSerie.year,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontFamily = FONT_FAMILY,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(height * 0.03f))
                    Guardar(
                        property1 = listOfPropertyButtons[index],
                        guardar = { searchViewModel.saveMovieOrSerie(movieOrSerie, movieOrSerieIndex) },
                        eliminar = { searchViewModel.deleteMovieOrSerie(movieOrSerie.idDoc, movieOrSerieIndex) }
                    )
                }
            }
        }
    }
}

