package app.ijiwon.pokedex.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute {
    @Serializable
    data object Main : NavigationRoute
    @Serializable
    data object Pokemon : NavigationRoute
}

sealed interface MainNavigationRoute : NavigationRoute {
    @Serializable
    data object Home : MainNavigationRoute
    @Serializable
    data object Pokedex : MainNavigationRoute
    @Serializable
    data object Moves : MainNavigationRoute
    @Serializable
    data object Items : MainNavigationRoute
}