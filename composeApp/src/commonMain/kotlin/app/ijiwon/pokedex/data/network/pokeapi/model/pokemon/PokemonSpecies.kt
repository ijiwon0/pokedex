package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.ApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Description
import app.ijiwon.pokedex.data.network.pokeapi.model.common.FlavorText
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecies(
    val id: Int,
    val name: String,
    val order: Int,
    @SerialName("gender_rate") val genderRate: Int,
    @SerialName("capture_rate") val captureRate: Int,
    @SerialName("base_happiness") val baseHappiness: Int,
    @SerialName("is_baby") val isBaby: Boolean,
    @SerialName("is_legendary") val isLegendary: Boolean,
    @SerialName("is_mythical") val isMythical: Boolean,
    @SerialName("hatch_counter") val hatchCounter: Int,
    @SerialName("has_gender_differences") val hasGenderDifferences: Boolean,
    @SerialName("forms_switchable") val formsSwitchable: Boolean,
    @SerialName("growth_rate") val growthRate: NamedApiResource,
    @SerialName("pokedex_numbers") val pokedexNumbers: List<PokemonSpeciesDexEntry>,
    @SerialName("egg_groups") val eggGroups: List<NamedApiResource>,
    val color: NamedApiResource,
    val shape: NamedApiResource,
    @SerialName("evolves_from_species") val evolvesFromSpecies: NamedApiResource?,
    @SerialName("evolution_chain") val evolutionChain: ApiResource,
    val habitat: NamedApiResource,
    val generation: NamedApiResource,
    val names: List<Name>,
    @SerialName("pal_park_encounters")
    val palParkEncounters: List<PalParkEncounterArea>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<FlavorText>,
    @SerialName("form_descriptions") val formDescriptions: List<Description>,
    val genera: List<Genus>,
    val varieties: List<PokemonSpeciesVariety>
)

@Serializable
data class Genus(
    val genus: String,
    val language: NamedApiResource
)

@Serializable
data class PokemonSpeciesDexEntry(
    @SerialName("entry_number") val entryNumber: Int,
    val pokedex: NamedApiResource,
)

@Serializable
data class PalParkEncounterArea(
    @SerialName("base_score") val baseScore: Int,
    val rate: Int,
    val area: NamedApiResource,
)

@Serializable
data class PokemonSpeciesVariety(
    @SerialName("is_default") val isDefault: Boolean,
    val pokemon: NamedApiResource,
)
