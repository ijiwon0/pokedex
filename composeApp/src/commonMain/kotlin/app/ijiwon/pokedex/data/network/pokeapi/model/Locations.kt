package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.GenerationGameIndex
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VersionEncounterDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Int,
    val name: String,
    val region: NamedApiResource,
    val names: List<Name>,
    @SerialName("game_indices")
    val gameIndices: List<GenerationGameIndex>,
    val areas: List<NamedApiResource>,
)

@Serializable
data class LocationArea(
    val id: Int,
    val name: String,
    @SerialName("game_index")
    val gameIndex: Int,
    @SerialName("encounter_method_rates")
    val encounterMethodRates: List<EncounterMethodRate>,
    val location: NamedApiResource,
    val names: List<Name>,
    @SerialName("pokemon_encounters")
    val pokemonEncounters: List<PokemonEncounter>,
)

@Serializable
data class EncounterMethodRate(
    @SerialName("encounter_method")
    val encounterMethod: NamedApiResource,
    @SerialName("version_details")
    val versionDetails: List<EncounterVersionDetails>,
)

@Serializable
data class EncounterVersionDetails(
    val rate: Int,
    val version: NamedApiResource,
)

@Serializable
data class PokemonEncounter(
    val pokemon: NamedApiResource,
    @SerialName("version_details")
    val versionDetails: List<VersionEncounterDetail>
)

@Serializable
data class PalParkArea(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("pokemon_encounters")
    val pokemonEncounters: List<PalParkEncounterSpecies>,
)

@Serializable
data class PalParkEncounterSpecies(
    @SerialName("base_score")
    val baseScore: Int,
    val rate: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: NamedApiResource,
)


@Serializable
data class Region(
    val id: Int,
    val name: String,
    val names: List<Name>,
    val locations: List<NamedApiResource>,
    @SerialName("main_generation")
    val mainGeneration: NamedApiResource,
    val pokedexes: List<NamedApiResource>,
    @SerialName("version_groups")
    val versionGroups: List<NamedApiResource>,
)