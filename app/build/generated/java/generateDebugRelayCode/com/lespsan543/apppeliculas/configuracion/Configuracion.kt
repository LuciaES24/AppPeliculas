package com.lespsan543.apppeliculas.configuracion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import com.lespsan543.apppeliculas.R

/**
 * This composable was generated from the UI Package 'configuracion'.
 * Generated code; do not edit directly
 */
@Composable
fun Configuracion(
    modifier: Modifier = Modifier,
    atras: () -> Unit = {},
    cambiarIdioma: () -> Unit = {},
    cerrarSesion: () -> Unit = {},
    eliminarCuenta: () -> Unit = {}
) {
    TopLevel(modifier = modifier) {
        Vector(atras = atras)
        ConfiguraciN()
        CambiarIdioma(cambiarIdioma = cambiarIdioma)
        CerrarSesiN(cerrarSesion = cerrarSesion)
        EliminarCuenta(eliminarCuenta = eliminarCuenta)
    }
}

@Preview(widthDp = 230, heightDp = 276)
@Composable
private fun ConfiguracionPreview() {
    MaterialTheme {
        RelayContainer {
            Configuracion(
                atras = {},
                cambiarIdioma = {},
                cerrarSesion = {},
                eliminarCuenta = {},
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun Vector(
    atras: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.configuracion_vector),
        modifier = modifier.tappable(onTap = atras).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun ConfiguraciN(modifier: Modifier = Modifier) {
    RelayText(
        content = "Configuración",
        fontSize = 28.0.sp,
        fontFamily = kameron,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.18701171875.em,
        maxLines = -1,
        modifier = modifier.requiredWidth(178.0.dp).requiredHeight(24.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CambiarIdioma(
    cambiarIdioma: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "Cambiar idioma",
        fontSize = 16.0.sp,
        fontFamily = kameron,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.18701171875.em,
        maxLines = -1,
        modifier = modifier.tappable(onTap = cambiarIdioma).requiredWidth(125.45453643798828.dp).requiredHeight(24.67866325378418.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun CerrarSesiN(
    cerrarSesion: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "Cerrar sesión",
        fontSize = 16.0.sp,
        fontFamily = kameron,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.18701171875.em,
        maxLines = -1,
        modifier = modifier.tappable(onTap = cerrarSesion).requiredWidth(109.09090423583984.dp).requiredHeight(16.19537353515625.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun EliminarCuenta(
    eliminarCuenta: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = "Eliminar cuenta",
        fontSize = 16.0.sp,
        fontFamily = kameron,
        color = Color(
            alpha = 255,
            red = 255,
            green = 0,
            blue = 0
        ),
        height = 1.18701171875.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.tappable(onTap = eliminarCuenta).requiredWidth(116.0.dp).requiredHeight(17.0.dp)
    )
}

@Composable
fun TopLevel(
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
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.End,
        padding = PaddingValues(
            start = 14.0.dp,
            top = 11.0.dp,
            end = 14.0.dp,
            bottom = 11.0.dp
        ),
        itemSpacing = 26.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
