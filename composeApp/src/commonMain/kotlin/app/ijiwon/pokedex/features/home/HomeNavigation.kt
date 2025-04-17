package app.ijiwon.pokedex.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.ijiwon.pokedex.navigation.MainNavigationRoute

fun NavGraphBuilder.homeScreen() {
    composable<MainNavigationRoute.Home> {
        HomeScreen()
    }
}