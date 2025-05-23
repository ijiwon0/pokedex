package app.ijiwon.pokedex.preview.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.ijiwon.pokedex.designsystem.component.ActivityIndicator
import app.ijiwon.pokedex.designsystem.theme.White

@Preview
@Composable
private fun ActivityIndicatorPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center,
    ) {
        ActivityIndicator()
    }
}