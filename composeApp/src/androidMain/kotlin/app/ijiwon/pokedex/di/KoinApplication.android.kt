package app.ijiwon.pokedex.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.KoinConfiguration
import org.koin.dsl.includes

@Composable
actual fun koinComposeMultiplatformConfiguration(
    configuration: KoinConfiguration
): KoinConfiguration {
    val applicationContext = LocalContext.current.applicationContext

    return KoinConfiguration {
        androidContext(applicationContext)
        includes(configuration)
    }
}