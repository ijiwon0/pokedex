package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionChain(
    val id: Int,
    @SerialName("baby_trigger_item")
    val babyTriggerItem: NamedApiResource?,
    val chain: ChainLink,
)

@Serializable
data class ChainLink(
    @SerialName("is_baby")
    val isBaby: Boolean,
    val species: NamedApiResource,
    @SerialName("evolution_details")
    val evolutionDetails: List<EvolutionDetail>,
    @SerialName("evolves_to")
    val evolvesTo: List<ChainLink>,
)

@Serializable
data class EvolutionDetail(
    val item: NamedApiResource?,
    val trigger: NamedApiResource,
    val gender: Int? = null,
    @SerialName("held_item")
    val heldItem: NamedApiResource? = null,
    @SerialName("known_move")
    val knownMove: NamedApiResource? = null,
    @SerialName("known_move_type")
    val knownMoveType: NamedApiResource? = null,
    val location: NamedApiResource? = null,
    @SerialName("min_level")
    val minLevel: Int? = null,
    @SerialName("min_happiness")
    val minHappiness: Int? = null,
    @SerialName("min_beauty")
    val minBeauty: Int? = null,
    @SerialName("min_affection")
    val minAffection: Int? = null,
    @SerialName("needs_overworld_rain")
    val needsOverworldRain: Boolean = false,
    @SerialName("party_species")
    val partySpecies: NamedApiResource? = null,
    @SerialName("party_type")
    val partyType: NamedApiResource? = null,
    @SerialName("relative_physical_stats")
    val relativePhysicalStats: Int? = null,
    @SerialName("time_of_day")
    val timeOfDay: String? = null,
    @SerialName("trade_species")
    val tradeSpecies: NamedApiResource? = null,
    @SerialName("turn_upside_down")
    val turnUpsideDown: Boolean = false,
)

/**
 * Evolution triggers are the events and conditions that cause a Pokémon to evolve.
 */
@Serializable
data class EvolutionTrigger(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("pokemon_species")
    val pokemonSpecies: List<NamedApiResource>,
)