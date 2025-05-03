package app.ijiwon.pokedex.features.pokemon.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.ijiwon.pokedex.designsystem.theme.Gray100
import app.ijiwon.pokedex.designsystem.theme.Gray50
import app.ijiwon.pokedex.designsystem.theme.Gray700
import app.ijiwon.pokedex.designsystem.theme.White
import app.ijiwon.pokedex.model.EvolutionChain
import app.ijiwon.pokedex.model.EvolutionTrigger
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.stringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.evolution

@Composable
internal fun PokemonEvolution(
    chain: EvolutionChain,
    modifier: Modifier = Modifier,
) {
    PokemonDetailsSection(
        title = {
            Text(stringResource(Res.string.evolution))
        },
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(Modifier.width(20.dp))

            chain.forEach { pokemon ->
                with(pokemon) {
                    val isNotRoot = evolvesFrom != null

                    if (isNotRoot) {
                        EvolutionTriggerLine(
                            trigger,
                            modifier = Modifier
                                .width(72.dp)
                                .padding(bottom = 16.dp),
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(Gray50, RoundedCornerShape(12.dp))
                                .border(1.dp, Gray100, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center,
                        ) {
                            AsyncImage(
                                artworkUrl,
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                            )
                        }

                        Text(
                            text = name.uppercase(),
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }

            Spacer(Modifier.width(20.dp))
        }
    }
}

@Composable
private fun EvolutionTriggerLine(
    trigger: EvolutionTrigger?,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        HorizontalDivider(color = Gray700)

        val minLevel = trigger?.minLevel
        val itemName = trigger?.itemName

        when {
            minLevel != null -> MinLevelLabel(minLevel)
            itemName != null -> ItemNameLabel(itemName)
        }
    }
}

@Composable
private fun MinLevelLabel(minLevel: Int) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .background(Gray700, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = minLevel.toString(),
            color = White,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Composable
private fun ItemNameLabel(itemName: String) {
    Box(
        modifier = Modifier
            .background(Gray700, RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = itemName.replace('-', '\n'),
            modifier = Modifier.widthIn(max = 40.dp),
            color = White,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}