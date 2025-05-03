package app.ijiwon.pokedex.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.compose.KoinContext
import org.koin.compose.application.CompositionKoinApplicationLoader
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.annotation.KoinInternalApi
import org.koin.dsl.KoinConfiguration
import org.koin.dsl.koinApplication

@Composable
fun KoinMultiplatformApplication(
    application: KoinApplication.() -> Unit,
    content: @Composable () -> Unit,
) {
    KoinContext(
        context = rememberKoinMultiplatformApplication(KoinConfiguration(application)),
        content = content,
    )
}

@Composable
expect fun koinComposeMultiplatformConfiguration(
    configuration: KoinConfiguration
): KoinConfiguration

@OptIn(KoinInternalApi::class)
@Composable
inline fun rememberKoinMultiplatformApplication(
    configuration: KoinConfiguration,
): Koin {
    val composeMultiplatformConfiguration = koinComposeMultiplatformConfiguration(configuration)

    val wrapper = remember(composeMultiplatformConfiguration) {
        CompositionKoinApplicationLoader(koinApplication(composeMultiplatformConfiguration))
    }

    return wrapper.koin ?: error("No Koin Context :(")
}