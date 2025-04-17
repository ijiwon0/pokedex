package app.ijiwon.pokedex.preview.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.designsystem.component.TextField
import app.ijiwon.pokedex.designsystem.theme.White

@Preview
@Composable
private fun TextFieldPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp),
        contentAlignment = Alignment.Center,
    ) {
        TextField(
            state = rememberTextFieldState(),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
        )
    }
}