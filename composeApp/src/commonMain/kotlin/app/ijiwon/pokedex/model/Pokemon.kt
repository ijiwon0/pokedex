package app.ijiwon.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    val nameJa: String,
    val genus: String,
    val artworkUrl: String,
    val showdownUrl: String,
    val types: List<PokemonType>,
    val stats: Stats,
    val height: Meter,
    val weight: Kilogram,
    val baseExperience: Int,
    val baseHappiness: Int,
    val captureRate: Int,
    val genderRate: Int,
    val hasGenderDifferences: Boolean,
    val isBaby: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean,
    val evolutionChain: EvolutionChain?,
    val varieties: List<PokedexEntry>,
) {
    @Serializable
    data class Stats(
        val hp: Int,
        val attack: Int,
        val defense: Int,
        val specialAttack: Int,
        val specialDefense: Int,
        val speed: Int,
    )

    @Serializable
    data class Variety(
        val id: Int,
        val name: String,
        val artworkUrl: String,
        val types: List<PokemonType>,
    )
}