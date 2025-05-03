package app.ijiwon.pokedex.features.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.ijiwon.pokedex.designsystem.theme.Green200
import app.ijiwon.pokedex.designsystem.theme.White
import app.ijiwon.pokedex.navigation.MainNavigationRoute
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navigationGraph: NavGraphBuilder.(nestedNavigationController: NavHostController) -> Unit,
) {
    MainContent(modifier, navigationGraph = navigationGraph)
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    navigationController: NavHostController = rememberNavController(),
    startDestination: MainNavigationDestination = MainNavigationDestination.Pokedex,
    destinations: ImmutableList<MainNavigationDestination> = MainNavigationDestination.entries.toImmutableList(),
    navigationGraph: NavGraphBuilder.(nestedNavigationController: NavHostController) -> Unit,
) {
    val navigationBackStackEntry by navigationController.currentBackStackEntryAsState()

    val destination by remember {
        derivedStateOf {
            destinations.find { destination ->
                navigationBackStackEntry
                    ?.destination
                    ?.hasRoute(destination.route::class) == true
            }
        }
    }

    Box(modifier) {
        Column {
            MainNavigationHost(
                navigationController,
                modifier = Modifier
                    .weight(1F)
                    .background(White),
                startDestination = startDestination.route,
                builder = navigationGraph,
            )

            BottomNavigationBar(
                destination = destination ?: startDestination,
                onClick = { destination ->
                    navigationController.navigate(destination.route) {
                        launchSingleTop = true

                        popUpTo(startDestination.route) {
                            saveState = true
                        }

                        restoreState = true
                    }
                },
                modifier = Modifier
                    .background(White),
                destinations = destinations,
            )
        }

        TopAppBar(
            title = stringResource((destination ?: startDestination).label)
        )
    }
}

@Composable
private fun TopAppBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .drawWithCache {
                val brush = Brush.verticalGradient(
                    listOf(
                        Green200,
                        Green200.copy(alpha = 0.95F),
                        Green200.copy(alpha = 0.8F),
                        Green200.copy(alpha = 0.5F),
                        Green200.copy(alpha = 0F),
                    ),
                )
                onDrawBehind {
                    drawRect(brush)
                }
            }
            .windowInsetsPadding(WindowInsets.statusBars),
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.headlineLarge,
        )
    }
}

@Composable
private fun MainNavigationHost(
    navigationController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: MainNavigationRoute = MainNavigationRoute.Home,
    builder: NavGraphBuilder.(nestedNavigationController: NavHostController) -> Unit,
) {
    NavHost(
        navigationController,
        startDestination,
        modifier,
        builder = {
            builder(navigationController)
        },
    )
}