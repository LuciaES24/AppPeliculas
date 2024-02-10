package com.lespsan543.apppeliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lespsan543.apppeliculas.ui.theme.AppPeliculasTheme
import com.lespsan543.apppeliculas.viewModel.MoviesViewModel
import com.lespsan543.apppeliculas.viewModel.ProfileViewModel
import com.lespsan543.apppeliculas.viewModel.SearchViewModel
import com.lespsan543.apppeliculas.viewModel.SeriesViewModel

class MainActivity : ComponentActivity() {
    private val moviesViewModel : MoviesViewModel by viewModels()
    private val seriesViewModel : SeriesViewModel by viewModels()
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

                }
            }
        }
    }
}