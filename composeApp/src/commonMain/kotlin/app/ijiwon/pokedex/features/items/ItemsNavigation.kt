package app.ijiwon.pokedex.features.items

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.ijiwon.pokedex.navigation.MainNavigationRoute

fun NavGraphBuilder.itemsScreen(onItemClick: (id: Int) -> Unit) {
    composable<MainNavigationRoute.Items> {
        ItemsScreen(onItemClick)
    }
}