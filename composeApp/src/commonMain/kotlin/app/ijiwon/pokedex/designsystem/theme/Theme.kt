package app.ijiwon.pokedex.designsystem.theme

import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
internal fun PokedexTheme(
    typography: Typography = PokedexTypography(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalRippleConfiguration provides null,
    ) {
        MaterialTheme(typography = typography, content = content)
    }
}