package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Effect
import app.ijiwon.pokedex.data.network.pokeapi.model.common.FlavorText
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests.
 */
@Serializable
data class ContestType(
    val id: Int,
    val name: String,
    @SerialName("berry_flavor")
    val berryFlavor: NamedApiResource,
    val names: List<ContestName>,
)

@Serializable
data class ContestName(
    val name: String,
    val color: String,
    val language: NamedApiResource,
)

@Serializable
data class ContestEffect(
    val id: Int,
    val appeal: Int,
    val jam: Int,
    @SerialName("effect_entries")
    val effectEntries: List<Effect>,
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorText>,
)

@Serializable
data class SuperContestEffect(
    val id: Int,
    val appeal: Int,
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorText>,
    val moves: List<NamedApiResource>
)