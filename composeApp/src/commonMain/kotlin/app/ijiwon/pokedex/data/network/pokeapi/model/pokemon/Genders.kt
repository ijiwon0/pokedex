package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Gender(
    val id: Int,
    val name: String,
    @SerialName("pokemon_species_details") val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
    @SerialName("required_for_evolution") val requiredForEvolution: List<NamedApiResource>
)

@Serializable
data class PokemonSpeciesGender(
    val rate: Int,
    @SerialName("pokemon_species") val pokemonSpecies: NamedApiResource
)