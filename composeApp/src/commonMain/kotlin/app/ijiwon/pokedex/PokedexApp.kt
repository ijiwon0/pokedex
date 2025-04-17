package app.ijiwon.pokedex

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.ijiwon.pokedex.core.designsystem.theme.PokedexTheme
import app.ijiwon.pokedex.core.navigation.NavigationRoute
import app.ijiwon.pokedex.features.main.mainScreen
import org.koin.compose.KoinContext

@Composable
internal fun PokedexApp() {
    KoinContext {
        PokedexTheme {
            NavigationHost()
        }
    }
}

@Composable
private fun NavigationHost(
    modifier: Modifier = Modifier,
    navigationController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navigationController,
        startDestination = NavigationRoute.Main,
    ) {
        mainScreen()
    }
}