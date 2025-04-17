package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Effect
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VerboseEffect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val id: Int,
    val name: String,
    @SerialName("is_main_series") val isMainSeries: Boolean,
    val generation: NamedApiResource,
    val names: List<Name>,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffect>,
    @SerialName("effect_changes") val effectChanges: List<AbilityEffectChange>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<AbilityFlavorText>,
    val pokemon: List<AbilityPokemon>
)

@Serializable
data class AbilityEffectChange(
    @SerialName("effect_entries")
    val effectEntries: List<Effect>,
    @SerialName("version_group")
    val versionGroup: NamedApiResource
)

@Serializable
data class AbilityFlavorText(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedApiResource,
    @SerialName("version_group") val versionGroup: NamedApiResource,
)

@Serializable
data class AbilityPokemon(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedApiResource
)