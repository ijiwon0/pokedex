package app.ijiwon.pokedex.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_black
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_bold
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_extra_bold
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_light
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_medium
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_regular
import pokedex.composeapp.generated.resources.m_plus_rounded_1c_thin

internal val MPlusRounded1C: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.m_plus_rounded_1c_thin, FontWeight.Thin),
        Font(Res.font.m_plus_rounded_1c_light, FontWeight.Light),
        Font(Res.font.m_plus_rounded_1c_regular, FontWeight.Normal),
        Font(Res.font.m_plus_rounded_1c_medium, FontWeight.Medium),
        Font(Res.font.m_plus_rounded_1c_bold, FontWeight.Bold),
        Font(Res.font.m_plus_rounded_1c_extra_bold, FontWeight.ExtraBold),
        Font(Res.font.m_plus_rounded_1c_black, FontWeight.Black),
    )

@Composable
internal fun PokedexTypography(fontFamily: FontFamily = MPlusRounded1C): Typography {
    val lineHeightStyle = LineHeightStyle(
        LineHeightStyle.Alignment.Center,
        LineHeightStyle.Trim.Both,
    )

    return Typography(
        displayLarge = TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        displayMedium = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        displaySmall = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        headlineLarge = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        headlineMedium = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        headlineSmall = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        bodyLarge = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        bodyMedium = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        bodySmall = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeightStyle = lineHeightStyle,
        ),
        labelLarge = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeight = 1.em,
            lineHeightStyle = lineHeightStyle,
        ),
        labelMedium = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeight = 1.em,
            lineHeightStyle = lineHeightStyle,
        ),
        labelSmall = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily,
            lineHeight = 1.em,
            lineHeightStyle = lineHeightStyle,
        ),
    )
}