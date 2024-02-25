package com.lespsan543.apppeliculas.peliculas.data.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.lespsan543.apppeliculas.R

/**
 * Archivo en el que se definen variables globales de toda la aplicación
 * como url de la api, apikey y colores para la Ui
 */
object Constants {
    //URL de la API
    const val BASE_URL = "https://www.omdbapi.com/"

    //Key de la API
    const val API_KEY = "apikey=a01dcc60"

    val FONT_FAMILY = FontFamily(Font(R.font.kameron_font))

}