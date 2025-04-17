package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonShape(
    val id: Int,
    val name: String,
    @SerialName("awesome_names") val awesomeNames: List<AwesomeName>,
    val names: List<Name>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedApiResource>,
)

@Serializable
data class AwesomeName(
    @SerialName("awesome_name") val awesomeName: String,
    val language: NamedApiResource,
)