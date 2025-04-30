package app.ijiwon.pokedex.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute {
    @Serializable
    data object Main : NavigationRoute
    @Serializable
    data class PokemonDetails(val id: Int) : NavigationRoute
}

sealed interface MainNavigationRoute : NavigationRoute {
    @Serializable
    data object Home : MainNavigationRoute
    @Serializable
    data object Pokedex : MainNavigationRoute
    @Serializable
    data object Items : MainNavigationRoute
}