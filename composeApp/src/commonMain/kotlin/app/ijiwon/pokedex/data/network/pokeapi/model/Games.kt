package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Description
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generation(
    val id: Int,
    val name: String,
    val abilities: List<NamedApiResource>,
    val names: List<Name>,
    @SerialName("main_region")
    val mainRegion: NamedApiResource,
    val moves: List<NamedApiResource>,
    @SerialName("pokemon_species")
    val pokemonSpecies: List<NamedApiResource>,
    val types: List<NamedApiResource>,
    @SerialName("version_groups")
    val versionGroups: List<NamedApiResource>,
)

@Serializable
data class Pokedex(
    val id: Int,
    val name: String,
    @SerialName("is_main_series")
    val isMainSeries: Boolean,
    val descriptions: List<Description>,
    val names: List<Name>,
    @SerialName("pokemon_entries")
    val pokemonEntries: List<PokemonEntry>,
    val region: NamedApiResource,
    @SerialName("version_groups")
    val versionGroups: List<NamedApiResource>,
)

@Serializable
data class PokemonEntry(
    @SerialName("entry_number")
    val entryNumber: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: NamedApiResource,
)

@Serializable
data class Version(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("version_group")
    val versionGroup: NamedApiResource,
)

@Serializable
data class VersionGroup(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedApiResource,
    @SerialName("move_learn_methods")
    val moveLearnMethods: List<NamedApiResource>,
    val pokedexes: List<NamedApiResource>,
    val regions: List<NamedApiResource>,
    val versions: List<NamedApiResource>,
)