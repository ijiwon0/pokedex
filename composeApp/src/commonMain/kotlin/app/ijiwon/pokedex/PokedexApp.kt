package app.ijiwon.pokedex

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.ijiwon.pokedex.designsystem.theme.PokedexTheme
import app.ijiwon.pokedex.di.KoinMultiplatformApplication
import app.ijiwon.pokedex.di.koinAppDeclaration
import app.ijiwon.pokedex.features.home.homeScreen
import app.ijiwon.pokedex.features.items.itemsScreen
import app.ijiwon.pokedex.features.main.mainScreen
import app.ijiwon.pokedex.features.pokedex.pokedexScreen
import app.ijiwon.pokedex.features.pokemon.pokemonDetailsScreen
import app.ijiwon.pokedex.navigation.NavigationRoute

@Composable
internal fun PokedexApp() {
    KoinMultiplatformApplication(koinAppDeclaration) {
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
        mainScreen {
            homeScreen()

            pokedexScreen(
                onPokemonClick = { id ->
                    navigationController.navigate(NavigationRoute.PokemonDetails(id))
                },
            )

            itemsScreen(onItemClick = {})
        }

        pokemonDetailsScreen(
            onBackClick = {
                navigationController.popBackStack()
            },
            onPokemonClick = { id ->
                navigationController.navigate(NavigationRoute.PokemonDetails(id))
            },
        )
    }
}