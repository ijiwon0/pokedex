package app.ijiwon.pokedex.features.pokemon.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.designsystem.theme.Gray200
import app.ijiwon.pokedex.designsystem.theme.Gray600
import app.ijiwon.pokedex.designsystem.theme.White

@Composable
internal fun PokemonDetailsSection(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .border(1.dp, Gray200, RoundedCornerShape(16.dp)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF7F7F8))
                .padding(12.dp),
            contentAlignment = Alignment.CenterStart,
        ) {
            ProvideTextStyle(
                value = MaterialTheme.typography.titleSmall.merge(
                    color = Gray600,
                    fontWeight = FontWeight.SemiBold,
                ),
                content = title,
            )
        }

        HorizontalDivider(color = Gray200)

        content()
    }
}