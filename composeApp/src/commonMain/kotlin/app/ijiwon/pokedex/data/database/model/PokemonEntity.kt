package app.ijiwon.pokedex.data.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.model.PokemonType

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val nameJa: String,
    val genus: String,
    val baseExperience: Int,
    val height: Int,
    val weight: Int,
    val baseHappiness: Int,
    val captureRate: Int,
    val genderRate: Int,
    val hasGenderDifferences: Boolean,
    val isBaby: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean,
    val types: List<PokemonType>,
    @Embedded val stats: Stats,
    val artworkUrl: String,
    val showdownUrl: String,
    val varieties: List<PokedexEntry>,
    val evolutionChainId: Int? = null,
    val isFavorite: Boolean = false,
) {
    data class Stats(
        val hp: Int,
        val attack: Int,
        val defense: Int,
        val specialAttack: Int,
        val specialDefense: Int,
        val speed: Int,
    )
}