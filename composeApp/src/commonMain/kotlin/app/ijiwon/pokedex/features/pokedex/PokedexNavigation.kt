package app.ijiwon.pokedex.features.pokedex

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.ijiwon.pokedex.core.navigation.MainNavigationRoute

fun NavGraphBuilder.pokedexScreen(onPokemonClick: (id: Int) -> Unit) {
    composable<MainNavigationRoute.Pokedex> {
        PokedexScreen(onPokemonClick)
    }
}