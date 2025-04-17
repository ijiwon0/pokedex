package app.ijiwon.pokedex.features.main

import app.ijiwon.pokedex.navigation.MainNavigationRoute
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.gameboy
import pokedex.composeapp.generated.resources.home
import pokedex.composeapp.generated.resources.items
import pokedex.composeapp.generated.resources.pokeball
import pokedex.composeapp.generated.resources.pokedex

enum class MainNavigationDestination(
    val icon: DrawableResource,
    val label: StringResource,
    val route: MainNavigationRoute,
) {
    HOME(
        icon = Res.drawable.home,
        label = Res.string.home,
        route = MainNavigationRoute.Home,
    ),
    POKEDEX(
        icon = Res.drawable.gameboy,
        label = Res.string.pokedex,
        route = MainNavigationRoute.Pokedex,
    ),
    ITEMS(
        icon = Res.drawable.pokeball,
        label = Res.string.items,
        route = MainNavigationRoute.Items,
    ),
}