package app.ijiwon.pokedex.core.ui.pokemon.type

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import app.ijiwon.pokedex.model.PokemonType

@Immutable
data class PokemonTypeColors(
    val labelColor: Color,
    val backgroundColor: Color,
    val borderColor: Color,
)

fun PokemonType.colors() = when (this) {
    PokemonType.NORMAL -> PokemonTypeColors(
        labelColor = Color(0xFF6D6D4E),
        borderColor = Color(0xFFC6C6A7),
        backgroundColor = Color(0xFFEDEDED)
    )
    PokemonType.FIRE -> PokemonTypeColors(
        labelColor = Color(0xFF9C531F),
        borderColor = Color(0xFFF5AC78),
        backgroundColor = Color(0xFFFBE3D4)
    )
    PokemonType.WATER -> PokemonTypeColors(
        labelColor = Color(0xFF445E9C),
        borderColor = Color(0xFF9DB7F5),
        backgroundColor = Color(0xFFE0ECFF)
    )
    PokemonType.ELECTRIC -> PokemonTypeColors(
        labelColor = Color(0xFFD4B51A),
        borderColor = Color(0xFFFDD73C),
        backgroundColor = Color(0xFFFFF2BC)
    )
    PokemonType.GRASS -> PokemonTypeColors(
        labelColor = Color(0xFF3B8336),
        borderColor = Color(0xFF6CD36D),
        backgroundColor = Color(0xFFBAE7C0)
    )
    PokemonType.ICE -> PokemonTypeColors(
        labelColor = Color(0xFF638D8D),
        borderColor = Color(0xFFBCE6E6),
        backgroundColor = Color(0xFFDFF7F7)
    )
    PokemonType.FIGHTING -> PokemonTypeColors(
        labelColor = Color(0xFF7D1F1A),
        borderColor = Color(0xFFC03028),
        backgroundColor = Color(0xFFF8D1D1)
    )
    PokemonType.POISON -> PokemonTypeColors(
        labelColor = Color(0xFF662194),
        borderColor = Color(0xFFD475F7),
        backgroundColor = Color(0xFFD9BBEE)
    )
    PokemonType.GROUND -> PokemonTypeColors(
        labelColor = Color(0xFF927D44),
        borderColor = Color(0xFFE0C068),
        backgroundColor = Color(0xFFF7E4B3)
    )
    PokemonType.FLYING -> PokemonTypeColors(
        labelColor = Color(0xFF6D5E9C),
        borderColor = Color(0xFFA890F0),
        backgroundColor = Color(0xFFDCD3F8)
    )
    PokemonType.PSYCHIC -> PokemonTypeColors(
        labelColor = Color(0xFFA13959),
        borderColor = Color(0xFFF85888),
        backgroundColor = Color(0xFFF8C6D4)
    )
    PokemonType.BUG -> PokemonTypeColors(
        labelColor = Color(0xFF6D7815),
        borderColor = Color(0xFFA8B820),
        backgroundColor = Color(0xFFE6F0A3)
    )
    PokemonType.ROCK -> PokemonTypeColors(
        labelColor = Color(0xFF786824),
        borderColor = Color(0xFFB8A038),
        backgroundColor = Color(0xFFE6D699)
    )
    PokemonType.GHOST -> PokemonTypeColors(
        labelColor = Color(0xFF493963),
        borderColor = Color(0xFF705898),
        backgroundColor = Color(0xFFD6C6E1)
    )
    PokemonType.DRAGON -> PokemonTypeColors(
        labelColor = Color(0xFF4924A1),
        borderColor = Color(0xFF7038F8),
        backgroundColor = Color(0xFFD2B5F8)
    )
    PokemonType.DARK -> PokemonTypeColors(
        labelColor = Color(0xFF4F3A2D),
        borderColor = Color(0xFF705848),
        backgroundColor = Color(0xFFD6C6B0)
    )
    PokemonType.STEEL -> PokemonTypeColors(
        labelColor = Color(0xFF7D7D81),
        borderColor = Color(0xFFB8B8D0),
        backgroundColor = Color(0xFFDEDEE6)
    )
    PokemonType.FAIRY -> PokemonTypeColors(
        labelColor = Color(0xFF9B6470),
        borderColor = Color(0xFFEE99AC),
        backgroundColor = Color(0xFFF7D6DE)
    )
    PokemonType.STELLAR -> PokemonTypeColors(
        labelColor = Color(0xFF1E88E5),
        borderColor = Color(0xFF64B5F6),
        backgroundColor = Color(0xFFE3F2FD)
    )
    PokemonType.SHADOW -> PokemonTypeColors(
        labelColor = Color(0xFF3D2B4D),
        borderColor = Color(0xFF6B5B95),
        backgroundColor = Color(0xFFB0A7C3)
    )
}