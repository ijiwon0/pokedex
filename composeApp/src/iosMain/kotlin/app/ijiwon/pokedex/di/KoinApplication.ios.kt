package app.ijiwon.pokedex.di

import androidx.compose.runtime.Composable
import org.koin.dsl.KoinConfiguration

@Composable
actual fun koinComposeMultiplatformConfiguration(
    configuration: KoinConfiguration
): KoinConfiguration {
    return configuration
}