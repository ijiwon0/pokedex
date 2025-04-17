package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.ApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Description
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Effect
import app.ijiwon.pokedex.data.network.pokeapi.model.common.GenerationGameIndex
import app.ijiwon.pokedex.data.network.pokeapi.model.common.MachineVersionDetail
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VerboseEffect
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VersionGroupFlavorText
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: Int,
    val name: String,
    val cost: Int,
    @SerialName("fling_power") val flingPower: Int,
    @SerialName("fling_effect") val flingEffect: NamedApiResource,
    val attributes: List<NamedApiResource>,
    val category: NamedApiResource,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffect>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<VersionGroupFlavorText>,
    @SerialName("game_indices") val gameIndices: List<GenerationGameIndex>,
    val names: List<Name>,
    val sprites: ItemSprites,
    @SerialName("held_by_pokemon") val heldByPokemon: List<ItemHolderPokemon>,
    @SerialName("baby_trigger_for") val babyTriggerFor: ApiResource? = null,
    val machines: List<MachineVersionDetail>,
)

@Serializable
data class ItemSprites(val default: String? = null)

@Serializable
data class ItemHolderPokemon(
    val pokemon: NamedApiResource,
    @SerialName("version_details")
    val versionDetails: List<ItemHolderPokemonVersionDetail>,
)

@Serializable
data class ItemHolderPokemonVersionDetail(
    val rarity: Int,
    val version: NamedApiResource,
)

@Serializable
data class ItemAttribute(
    val id: Int,
    val name: String,
    val items: List<NamedApiResource>,
    val names: List<Name>,
    val descriptions: List<Description>,
)

@Serializable
data class ItemCategory(
    val id: Int,
    val name: String,
    val items: List<NamedApiResource>,
    val names: List<Name>,
    val pocket: NamedApiResource,
)

@Serializable
data class ItemFlingEffect(
    val id: Int,
    val name: String,
    @SerialName("effect_entries")
    val effectEntries: List<Effect>,
    val items: List<NamedApiResource>,
)

@Serializable
data class ItemPocket(
    val id: Int,
    val name: String,
    val categories: List<NamedApiResource>,
    val names: List<Name>,
)