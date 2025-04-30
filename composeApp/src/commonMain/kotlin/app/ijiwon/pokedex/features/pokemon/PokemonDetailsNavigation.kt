package app.ijiwon.pokedex.features.pokemon

import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import app.ijiwon.pokedex.navigation.NavigationRoute

fun NavGraphBuilder.pokemonDetailsScreen(modifier: Modifier = Modifier) {
    composable<NavigationRoute.PokemonDetails> { entry: NavBackStackEntry ->
        val id = entry
            .toRoute<NavigationRoute.PokemonDetails>()
            .id

        PokemonDetailsScreen(id, modifier)
    }
}