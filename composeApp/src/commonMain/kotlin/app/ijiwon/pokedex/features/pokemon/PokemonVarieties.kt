package app.ijiwon.pokedex.features.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.designsystem.theme.Gray200
import app.ijiwon.pokedex.designsystem.theme.Gray50
import app.ijiwon.pokedex.designsystem.theme.White
import app.ijiwon.pokedex.features.pokedex.PokedexListItem
import app.ijiwon.pokedex.model.PokedexEntry
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.varieties

@Composable
internal fun PokemonVarieties(
    varieties: ImmutableList<PokedexEntry>,
    onVarietyClick: (PokedexEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .border(1.dp, Gray200, RoundedCornerShape(16.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray50)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color(0xFF24C26D), RoundedCornerShape(6.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(Res.drawable.varieties),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }

            Text(
                stringResource(Res.string.varieties),
                style = MaterialTheme.typography.titleMedium,
            )
        }

        HorizontalDivider(color = Gray200)

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            varieties.forEach { variety ->
                PokedexListItem(variety, onClick = onVarietyClick)
            }
        }
    }
}