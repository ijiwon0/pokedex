package app.ijiwon.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class PokedexEntry(
    val id: Int,
    val artworkUrl: String,
    val name: String,
    val types: List<PokemonType>,
)