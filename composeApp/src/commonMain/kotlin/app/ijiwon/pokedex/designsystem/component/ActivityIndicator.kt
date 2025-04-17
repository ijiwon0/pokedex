package app.ijiwon.pokedex.designsystem.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.designsystem.theme.Gray100
import app.ijiwon.pokedex.designsystem.theme.Gray300
import app.ijiwon.pokedex.designsystem.theme.Gray500

@Composable
fun ActivityIndicator(
    modifier: Modifier = Modifier,
    count: Int = ActivityIndicatorDefaults.SPOKE_COUNT,
    animatedCount: Int = ActivityIndicatorDefaults.ANIMATED_SPOKE_COUNT,
    innerRadius: Float = 1 / 3F,
    color: Color = Gray500,
    minAlpha: Float = ActivityIndicatorDefaults.MIN_ALPHA,
) {
    require(count > ActivityIndicatorDefaults.MIN_SPOKE_COUNT)

    require(minAlpha in 0F..1F)

    val unitAngle = 360 / count

    val infiniteTransition = rememberInfiniteTransition()

    val step by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = count.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = ActivityIndicatorDefaults.DURATION_MILLIS,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
    )

    Box(
        modifier = modifier
            .size(80.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(1.dp, Gray300, RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.size(32.dp)) {
            val itemWidth = size.width * (1 - innerRadius) / 2

            val itemHeight = size.height / count

            val itemSize = Size(itemWidth, itemHeight)

            val cornerRadius = itemWidth.coerceAtMost(itemHeight) / 2

            val topLeft = Offset(
                x = size.width - itemWidth,
                y = (size.height - itemHeight) / 2,
            )

            for (angle in 0 until 360 step unitAngle) {
                rotate(angle.toFloat()) {
                    drawRoundRect(
                        color = color.copy(alpha = minAlpha),
                        topLeft = topLeft,
                        size = itemSize,
                        cornerRadius = CornerRadius(cornerRadius),
                    )
                }
            }

            for (i in 1..animatedCount) {
                rotate((step.toInt() + i) * unitAngle.toFloat()) {
                    drawRoundRect(
                        color = color.copy(alpha = 1F / (i * i)),
                        topLeft = topLeft,
                        size = itemSize,
                        cornerRadius = CornerRadius(cornerRadius),
                    )
                }
            }
        }
    }
}

object ActivityIndicatorDefaults {
    const val MIN_ALPHA: Float = 0.1F
    const val MIN_SPOKE_COUNT: Int = 4
    const val SPOKE_COUNT: Int = 8
    const val ANIMATED_SPOKE_COUNT: Int = 4
    const val DURATION_MILLIS: Int = 1000
}