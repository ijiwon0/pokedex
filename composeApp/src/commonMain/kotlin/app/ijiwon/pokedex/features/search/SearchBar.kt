package app.ijiwon.pokedex.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.core.designsystem.component.TextField
import app.ijiwon.pokedex.core.designsystem.theme.Gray100
import app.ijiwon.pokedex.core.designsystem.theme.Gray300
import app.ijiwon.pokedex.core.designsystem.theme.Gray50
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.filter
import pokedex.composeapp.generated.resources.search

@Composable
internal fun SearchBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val state = rememberTextFieldState()

        TextField(
            state = state,
            modifier = Modifier
                .weight(1F)
                .height(40.dp),
            placeholder = {
                Text("Name, Number or Type")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = null,
                    tint = Gray300,
                )
            }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(25))
                .background(Gray50)
                .border(1.dp, Gray100, RoundedCornerShape(25))
                .clickable {
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(Res.drawable.filter),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Gray300,
            )
        }
    }
}