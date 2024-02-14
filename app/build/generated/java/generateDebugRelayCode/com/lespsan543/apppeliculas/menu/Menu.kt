package com.lespsan543.apppeliculas.menu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable
import com.lespsan543.apppeliculas.R

// Design to select for Menu
enum class Property1 {
    Inicio,
    Buscar,
    Perfil
}

/**
 * This composable was generated from the UI Package 'menu'.
 * Generated code; do not edit directly
 */
@Composable
fun Menu(
    modifier: Modifier = Modifier,
    property1: Property1 = Property1.Inicio,
    home: () -> Unit = {},
    search: () -> Unit = {},
    profile: () -> Unit = {},
    home2: () -> Unit = {},
    search2: () -> Unit = {},
    profile2: () -> Unit = {},
    home3: () -> Unit = {},
    search3: () -> Unit = {},
    profile3: () -> Unit = {}
) {
    when (property1) {
        Property1.Inicio -> TopLevelProperty1Inicio(modifier = modifier) {
            HomeBProperty1Inicio(home = home)
            LupaW2Property1Inicio(search = search) {
                Lupa22WProperty1Inicio(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Lupa2WProperty1Inicio(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            PerfilWProperty1Inicio(profile = profile)
        }
        Property1.Buscar -> TopLevelProperty1Buscar(modifier = modifier) {
            HomeW2Property1Buscar(home2 = home2)
            LupaBProperty1Buscar(search2 = search2) {
                LupaB2Property1Buscar(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                LupaB1Property1Buscar(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            Perfil2WProperty1Buscar(profile2 = profile2)
        }
        Property1.Perfil -> TopLevelProperty1Perfil(modifier = modifier) {
            HomeW1Property1Perfil(home3 = home3)
            LupaW1Property1Perfil(search3 = search3) {
                Lupa11WProperty1Perfil(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                Lupa1WProperty1Perfil(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            PerfilBProperty1Perfil(profile3 = profile3)
        }
    }
}

@Preview(widthDp = 360, heightDp = 50)
@Composable
private fun MenuProperty1InicioPreview() {
    MaterialTheme {
        RelayContainer {
            Menu(
                home = {},
                search = {},
                profile = {},
                home2 = {},
                search2 = {},
                profile2 = {},
                home3 = {},
                search3 = {},
                profile3 = {},
                property1 = Property1.Inicio,
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 50)
@Composable
private fun MenuProperty1BuscarPreview() {
    MaterialTheme {
        RelayContainer {
            Menu(
                home = {},
                search = {},
                profile = {},
                home2 = {},
                search2 = {},
                profile2 = {},
                home3 = {},
                search3 = {},
                profile3 = {},
                property1 = Property1.Buscar,
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 50)
@Composable
private fun MenuProperty1PerfilPreview() {
    MaterialTheme {
        RelayContainer {
            Menu(
                home = {},
                search = {},
                profile = {},
                home2 = {},
                search2 = {},
                profile2 = {},
                home3 = {},
                search3 = {},
                profile3 = {},
                property1 = Property1.Perfil,
                modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
            )
        }
    }
}

@Composable
fun HomeBProperty1Inicio(
    home: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.menu_home_b),
        modifier = modifier.tappable(onTap = home).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun Lupa22WProperty1Inicio(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.menu_lupa22w),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 5.599998474121094.dp,
                bottom = 5.5841522216796875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Lupa2WProperty1Inicio(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.menu_lupa2w),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 16.36419677734375.dp,
                top = 16.499771118164062.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun LupaW2Property1Inicio(
    search: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = search).requiredWidth(27.999996185302734.dp).requiredHeight(28.000001907348633.dp)
    )
}

@Composable
fun PerfilWProperty1Inicio(
    profile: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.menu_perfil_w),
        modifier = modifier.tappable(onTap = profile).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun TopLevelProperty1Inicio(
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
            start = 40.0.dp,
            top = 10.0.dp,
            end = 40.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 100.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun HomeW2Property1Buscar(
    home2: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.menu_home_w2),
        modifier = modifier.tappable(onTap = home2).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun LupaB2Property1Buscar(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.menu_lupa_b2),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 5.599998474121094.dp,
                bottom = 5.5841522216796875.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun LupaB1Property1Buscar(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.menu_lupa_b1),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 16.36419677734375.dp,
                top = 16.499771118164062.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun LupaBProperty1Buscar(
    search2: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = search2).requiredWidth(27.999996185302734.dp).requiredHeight(28.000001907348633.dp)
    )
}

@Composable
fun Perfil2WProperty1Buscar(
    profile2: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.menu_perfil2w),
        modifier = modifier.tappable(onTap = profile2).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun TopLevelProperty1Buscar(
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
            start = 40.0.dp,
            top = 10.0.dp,
            end = 40.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 100.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun HomeW1Property1Perfil(
    home3: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.menu_home_w1),
        modifier = modifier.tappable(onTap = home3).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun Lupa11WProperty1Perfil(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.menu_lupa11w),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 0.0.dp,
                top = 0.0.dp,
                end = 5.600002288818359.dp,
                bottom = 5.584150314331055.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Lupa1WProperty1Perfil(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.menu_lupa1w),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 16.36419677734375.dp,
                top = 16.499771118164062.dp,
                end = 0.0.dp,
                bottom = 0.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun LupaW1Property1Perfil(
    search3: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = search3).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
    )
}

@Composable
fun PerfilBProperty1Perfil(
    profile3: () -> Unit,
    modifier: Modifier = Modifier
) {
    RelayVector(
        vector = painterResource(R.drawable.menu_perfil_b),
        modifier = modifier.tappable(onTap = profile3).requiredWidth(28.0.dp).requiredHeight(28.0.dp)
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
            start = 40.0.dp,
            top = 10.0.dp,
            end = 40.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 100.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
