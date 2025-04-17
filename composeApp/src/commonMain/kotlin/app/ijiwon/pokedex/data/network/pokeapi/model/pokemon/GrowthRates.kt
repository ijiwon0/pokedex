package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Description
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GrowthRate(
    val id: Int,
    val name: String,
    val formula: String,
    val descriptions: List<Description>,
    val levels: List<GrowthRateExperienceLevel>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedApiResource>
)

@Serializable
data class GrowthRateExperienceLevel(
    val level: Int,
    val experience: Int
)