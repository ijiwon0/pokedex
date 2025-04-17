package app.ijiwon.pokedex.data.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.ijiwon.pokedex.model.PokemonType
import kotlinx.serialization.Serializable

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val names: List<NameEntity> = emptyList(),
    val species: String? = null,
    val baseExperience: Int,
    val height: Int,
    val weight: Int,
    val types: List<PokemonType>,
    @Embedded val stats: PokemonStatsEntity,
    val imageUrl: String,
    val showdownUrl: String?,
    val varieties: List<PokemonSpeciesVarietyEntity> = emptyList(),
)

data class PokemonStatsEntity(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int,
)

@Serializable
data class PokemonSpeciesVarietyEntity(
    val name: String,
    val imageUrl: String,
    val types: List<PokemonType>,
)

@Serializable
data class NameEntity(
    val name: String,
    val language: String,
)