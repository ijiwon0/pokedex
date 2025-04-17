package app.ijiwon.pokedex.features.pokedex

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.ijiwon.pokedex.core.designsystem.theme.Gray100
import app.ijiwon.pokedex.core.designsystem.theme.Gray50
import app.ijiwon.pokedex.core.designsystem.theme.Gray700
import app.ijiwon.pokedex.core.designsystem.theme.Gray900
import app.ijiwon.pokedex.core.ui.pokemon.type.colors
import app.ijiwon.pokedex.model.Pokemon
import coil3.compose.AsyncImage

@Composable
internal fun PokedexEntry(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    onClick: (Pokemon) -> Unit,
) = with(pokemon) {
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) {
            0.95F
        } else {
            1F
        },
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {
                onClick(pokemon)
            }
            .padding(horizontal = 4.dp)
            .background(
                color = if (isPressed) {
                    Gray100
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(12.dp),
            )
            .padding(4.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Gray50, RoundedCornerShape(8.dp))
                .border(1.dp, Gray100, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            val model = if (isPressed) {
                showdownUrl ?: imageUrl
            } else {
                imageUrl
            }

            AsyncImage(
                model = model,
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                contentScale = ContentScale.Fit,
            )
        }

        Column(modifier = Modifier.weight(1F)) {
            Text(
                text = name,
                color = Gray900,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge,
            )

            Text(
                text = when (id) {
                    in 1..9 -> "#000$id"
                    in 10..99 -> "#00$id"
                    in 100..999 -> "#0$id"
                    else -> "#$id"
                },
                color = Gray700,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelMedium,
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            types.forEach { type ->
                val colors = type.colors()

                Box(
                    modifier = Modifier
                        .border(1.dp, colors.borderColor, RoundedCornerShape(4.dp))
                        .background(colors.backgroundColor, RoundedCornerShape(4.dp))
                        .padding(horizontal = 4.dp, vertical = 2.dp),
                ) {
                    Text(
                        text = type.name.uppercase(),
                        color = colors.labelColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
        }
    }
}