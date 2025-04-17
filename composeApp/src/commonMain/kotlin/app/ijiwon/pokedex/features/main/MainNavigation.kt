package app.ijiwon.pokedex.features.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.ijiwon.pokedex.core.navigation.NavigationRoute

internal fun NavGraphBuilder.mainScreen() {
    composable<NavigationRoute.Main> {
        MainScreen()
    }
}