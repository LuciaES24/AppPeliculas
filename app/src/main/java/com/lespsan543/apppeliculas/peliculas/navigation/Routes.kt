package com.lespsan543.apppeliculas.peliculas.navigation

/**
 * Gestiona las diferentes rutas que componen la navegación de la aplicación
 * @param route ruta a la que va a dirigirse
 */
sealed class Routes(val route:String) {
    object LogInScreen : Routes("LogInScreen")

    object RegisterScreen : Routes("RegisterScreen")

    object MoviesScreen : Routes("MoviesScreen")

    object SeriesScreen : Routes("SeriesScreen")

    object ProfileScreen : Routes("ProfileScreen")

    object SearchScreen : Routes("SearchScreen")
}