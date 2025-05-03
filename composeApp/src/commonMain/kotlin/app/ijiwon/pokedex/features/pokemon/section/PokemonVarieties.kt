package app.ijiwon.pokedex.features.pokemon.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.ui.pokedex.PokedexListItem
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.varieties

@Composable
internal fun PokemonVarieties(
    varieties: ImmutableList<PokedexEntry>,
    onVarietyClick: (PokedexEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    PokemonDetailsSection(
        title = {
            Text(stringResource(Res.string.varieties))
        },
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            varieties.forEach { variety ->
                val name = variety.name
                    .split(DASH)
                    .joinToString(separator = SPACE) {
                        it.take(1).uppercase() + it.drop(1)
                    }

                PokedexListItem(
                    entry = variety.copy(name = name),
                    onClick = onVarietyClick,
                )
            }
        }
    }
}

internal const val DASH = "-"
internal const val SPACE = " "