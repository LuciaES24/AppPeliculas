package com.lespsan543.apppeliculas.cabecera

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import com.lespsan543.apppeliculas.R

// Design to select for Cabecera
enum class Property1 {
    Perfil,
    BuscarPeli
}

/**
 * This composable was generated from the UI Package 'cabecera'.
 * Generated code; do not edit directly
 */
@Composable
fun Cabecera(
    modifier: Modifier = Modifier,
    property1: Property1 = Property1.Perfil,
    salir: () -> Unit = {}
) {
    when (property1) {
        Property1.Perfil -> TopLevelProperty1Perfil(modifier = modifier) {
            FavoritosProperty1Perfil(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            VectorProperty1Perfil(salir = salir)
        }
        Property1.BuscarPeli -> TopLevelProperty1BuscarPeli(modifier = modifier) {
            BuscarProperty1BuscarPeli(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Preview(widthDp = 360, heightDp = 56)
@Composable
private fun CabeceraProperty1PerfilPreview() {
    MaterialTheme {
        RelayContainer {
            Cabecera(
                salir = {},
                property1 = Property1.Perfil,
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Preview(widthDp = 358, heightDp = 57)
@Composable
private fun CabeceraProperty1BuscarPeliPreview() {
    MaterialTheme {
        RelayContainer {
            Cabecera(
                salir = {},
                property1 = Property1.BuscarPeli,
                modifier = Modifier.rowWeight(1.0f)
            )
        }
    }
}

@Composable
fun FavoritosProperty1Perfil(modifier: Modifier = Modifier) {
    RelayText(
        content = "Favoritos",
        fontSize = 28.0.sp,
        fontFamily = kameron,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.18701171875.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun VectorProperty1Perfil(
    salir: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.cabecera_vector),
        modifier = modifier.tappable(onTap = salir).requiredWidth(27.1875.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun TopLevelProperty1Perfil(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 107,
            green = 107,
            blue = 107
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 125.0.dp,
            top = 12.0.dp,
            end = 15.0.dp,
            bottom = 12.0.dp
        ),
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun BuscarProperty1BuscarPeli(modifier: Modifier = Modifier) {
    RelayText(
        content = "Buscar",
        fontSize = 28.0.sp,
        fontFamily = kameron,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.18701171875.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun TopLevelProperty1BuscarPeli(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 107,
            green = 107,
            blue = 107
        ),
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 136.0.dp,
            top = 12.0.dp,
            end = 136.0.dp,
            bottom = 12.0.dp
        ),
        itemSpacing = 10.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}
