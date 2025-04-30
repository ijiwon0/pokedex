package app.ijiwon.pokedex.features.main

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.ijiwon.pokedex.navigation.NavigationRoute

internal fun NavGraphBuilder.mainScreen(
    modifier: Modifier = Modifier,
    navigationGraph: NavGraphBuilder.(nestedNavigationController: NavHostController) -> Unit,
) {
    composable<NavigationRoute.Main> {
        MainScreen(modifier, navigationGraph)
    }
}