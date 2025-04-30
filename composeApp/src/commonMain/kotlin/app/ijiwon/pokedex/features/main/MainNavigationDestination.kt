package app.ijiwon.pokedex.features.main

import app.ijiwon.pokedex.navigation.MainNavigationRoute
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.home
import pokedex.composeapp.generated.resources.home_selected
import pokedex.composeapp.generated.resources.home_unselected
import pokedex.composeapp.generated.resources.item_selected
import pokedex.composeapp.generated.resources.item_unselected
import pokedex.composeapp.generated.resources.items
import pokedex.composeapp.generated.resources.pokedex
import pokedex.composeapp.generated.resources.pokedex_selected
import pokedex.composeapp.generated.resources.pokedex_unselected

enum class MainNavigationDestination(
    val unselectedIcon: DrawableResource,
    val selectedIcon: DrawableResource,
    val label: StringResource,
    val route: MainNavigationRoute,
) {
    Home(
        unselectedIcon = Res.drawable.home_unselected,
        selectedIcon = Res.drawable.home_selected,
        label = Res.string.home,
        route = MainNavigationRoute.Home,
    ),
    Pokedex(
        unselectedIcon = Res.drawable.pokedex_unselected,
        selectedIcon = Res.drawable.pokedex_selected,
        label = Res.string.pokedex,
        route = MainNavigationRoute.Pokedex,
    ),
    Items(
        unselectedIcon = Res.drawable.item_unselected,
        selectedIcon = Res.drawable.item_selected,
        label = Res.string.items,
        route = MainNavigationRoute.Items,
    ),
}