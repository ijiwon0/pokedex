package app.ijiwon.pokedex.ui.error

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.designsystem.theme.Gray200
import app.ijiwon.pokedex.designsystem.theme.Gray50
import app.ijiwon.pokedex.designsystem.theme.Gray700
import app.ijiwon.pokedex.designsystem.theme.Red500
import app.ijiwon.pokedex.designsystem.theme.White
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.oops
import pokedex.composeapp.generated.resources.try_again
import pokedex.composeapp.generated.resources.x_close

@Composable
fun ErrorView(
    message: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(Red500, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(Res.drawable.x_close),
                contentDescription = null,
                tint = White,
            )
        }

        Text(
            text = stringResource(Res.string.oops),
            style = MaterialTheme.typography.displayLarge,
        )

        Text(
            text = message,
            modifier = Modifier.padding(horizontal = 48.dp),
            color = Gray700,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )

        Spacer(Modifier)

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(52.dp)
                .clip(CircleShape)
                .background(Gray50)
                .border(1.dp, Gray200, CircleShape)
                .clickable(onClick = onRetryClick),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(Res.string.try_again),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}