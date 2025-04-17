package app.ijiwon.pokedex.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Content(modifier)
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
) {
    Box(modifier)
}