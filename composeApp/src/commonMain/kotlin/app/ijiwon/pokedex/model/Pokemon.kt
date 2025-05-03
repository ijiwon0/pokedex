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
        val hp: Stat,
        val attack: Stat,
        val defense: Stat,
        val specialAttack: Stat,
        val specialDefense: Stat,
        val speed: Stat,
    ) {
        val total: Int
            get() = hp.value + attack.value + defense.value + specialAttack.value + specialDefense.value + speed.value
    }

    @Serializable
    data class Stat(val type: StatType, val value: Int)

    enum class StatType {
        HP,
        ATTACK,
        DEFENSE,
        SPECIAL_ATTACK,
        SPECIAL_DEFENSE,
        SPEED,
    }
}