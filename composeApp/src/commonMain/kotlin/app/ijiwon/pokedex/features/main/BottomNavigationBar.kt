package app.ijiwon.pokedex.features.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.ijiwon.pokedex.designsystem.theme.Gray50
import app.ijiwon.pokedex.designsystem.theme.Gray500
import app.ijiwon.pokedex.designsystem.theme.Gray900
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun BottomNavigationBar(
    destination: MainNavigationDestination,
    onClick: (MainNavigationDestination) -> Unit,
    modifier: Modifier = Modifier,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = Gray900,
        selectedTextColor = Gray900,
        unselectedIconColor = Gray500,
        unselectedTextColor = Gray500,
    ),
    destinations: ImmutableList<MainNavigationDestination> = MainNavigationDestination.entries.toImmutableList(),
) {
    Column(modifier) {
        HorizontalDivider(color = Gray50)

        Row(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.navigationBars)
                .fillMaxWidth()
                .height(52.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            destinations.forEach { mDestination ->
                val selected = destination == mDestination

                val (iconColor, textColor) = with(colors) {
                    if (selected) {
                        selectedIconColor to selectedTextColor
                    } else {
                        unselectedIconColor to unselectedTextColor
                    }
                }

                BottomNavigationBarItem(
                    selected,
                    mDestination,
                    iconColor,
                    textColor,
                    modifier = Modifier
                        .weight(1F),
                    onClick = onClick,
                )
            }
        }
    }
}

@Composable
private fun BottomNavigationBarItem(
    selected: Boolean,
    destination: MainNavigationDestination,
    iconColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: (MainNavigationDestination) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onClick(destination)
            },
        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(destination.icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = iconColor,
        )

        Text(
            text = stringResource(destination.label),
            color = textColor,
            fontSize = 11.sp,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}