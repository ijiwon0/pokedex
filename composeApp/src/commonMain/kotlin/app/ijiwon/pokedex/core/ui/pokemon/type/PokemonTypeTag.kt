package app.ijiwon.pokedex.core.ui.pokemon.type

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.model.PokemonType

@Composable
fun PokemonTypeTag(
    type: PokemonType,
    modifier: Modifier = Modifier,
    colors: PokemonTypeColors = type.colors(),
) = with(type) {
    with(colors) {
        Box(modifier) {
            Text(
                text = name.uppercase(),
                modifier = Modifier
                    .background(backgroundColor, RoundedCornerShape(4.dp))
                    .border(1.dp, borderColor, RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                color = labelColor,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}