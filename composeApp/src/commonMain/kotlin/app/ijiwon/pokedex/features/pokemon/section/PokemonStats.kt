package app.ijiwon.pokedex.features.pokemon.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.designsystem.theme.Gray500
import app.ijiwon.pokedex.designsystem.theme.Gray900
import app.ijiwon.pokedex.model.Pokemon
import org.jetbrains.compose.resources.stringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.attack
import pokedex.composeapp.generated.resources.base_stats
import pokedex.composeapp.generated.resources.defence
import pokedex.composeapp.generated.resources.hp
import pokedex.composeapp.generated.resources.special_attack
import pokedex.composeapp.generated.resources.special_defence
import pokedex.composeapp.generated.resources.speed
import pokedex.composeapp.generated.resources.total_stats

@Composable
internal fun PokemonStats(
    stats: Pokemon.Stats,
    modifier: Modifier = Modifier
) = with(stats) {
    PokemonDetailsSection(
        title = {
            Text(stringResource(Res.string.base_stats))
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            remember(stats) {
                listOf(hp, attack, defense, specialAttack, specialDefense, speed)
            }.forEach { stat ->
                StatEntry(stat.type, stat.value)
            }

            Text(
                text = stringResource(Res.string.total_stats, total),
                style = MaterialTheme.typography.headlineLarge,
            )
        }
    }
}

private val Pokemon.StatType.displayName: String
    @Composable
    get() = when (this) {
        Pokemon.StatType.HP -> stringResource(Res.string.hp)
        Pokemon.StatType.ATTACK -> stringResource(Res.string.attack)
        Pokemon.StatType.DEFENSE -> stringResource(Res.string.defence)
        Pokemon.StatType.SPECIAL_ATTACK -> stringResource(Res.string.special_attack)
        Pokemon.StatType.SPECIAL_DEFENSE -> stringResource(Res.string.special_defence)
        Pokemon.StatType.SPEED -> stringResource(Res.string.speed)
    }

private val Pokemon.StatType.color: Color
    get() = when (this) {
        Pokemon.StatType.HP -> Color(0xFFEC685B)
        Pokemon.StatType.ATTACK -> Color(0xFFF3AC4D)
        Pokemon.StatType.DEFENSE -> Color(0xFFF8D754)
        Pokemon.StatType.SPECIAL_ATTACK -> Color(0xFF488CF7)
        Pokemon.StatType.SPECIAL_DEFENSE -> Color(0xFF7AD580)
        Pokemon.StatType.SPEED -> Color(0xFFEB5369)
    }

@Composable
private fun StatEntry(
    type: Pokemon.StatType,
    value: Int,
    modifier: Modifier = Modifier,
    maxValue: Int = 255,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box {
            Text(
                text = stringResource(Res.string.special_defence), // longest name
                modifier = Modifier.alpha(0F),
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelMedium,
            )

            Text(
                text = type.displayName,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelMedium,
            )
        }

        Box(
            modifier = Modifier.weight(1F),
            contentAlignment = Alignment.CenterStart,
        ) {
            val color = type.color

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(color.copy(alpha = 0.2F), CircleShape),
            )

            val fraction = value.toFloat() / maxValue

            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction)
                    .height(12.dp)
                    .background(color, CircleShape),
            )
        }

        Box(contentAlignment = Alignment.CenterEnd) {
            Text(
                text = "$maxValue/$maxValue",
                modifier = Modifier.alpha(0F),
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelMedium,
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(Gray900)) {
                        append(value.toString())
                    }

                    withStyle(SpanStyle(Gray500)) {
                        append("/$maxValue")
                    }
                },
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
private fun StatBar(
    type: Pokemon.StatType,
    value: Int,
    modifier: Modifier = Modifier,
    maxValue: Int = 255,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        val color = type.color

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(color.copy(alpha = 0.2F), CircleShape),
        )

        val fraction = value.toFloat() / maxValue

        Box(
            modifier = Modifier
                .fillMaxWidth(fraction)
                .height(12.dp)
                .background(color, CircleShape),
        )
    }
}