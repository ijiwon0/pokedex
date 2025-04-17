package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonForm(
    val id: Int,
    val name: String,
    val order: Int,
    @SerialName("form_order") val formOrder: Int,
    @SerialName("is_default") val isDefault: Boolean,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("is_mega") val isMega: Boolean,
    @SerialName("form_name") val formName: String,
    val pokemon: NamedApiResource,
    val types: List<PokemonFormType>,
    val sprites: PokemonFormSprites,
    @SerialName("version_group") val versionGroup: NamedApiResource,
    val names: List<Name>,
    @SerialName("form_names") val formNames: List<Name>,
)

@Serializable
data class PokemonFormType(
    val slot: Int,
    val type: NamedApiResource
)

@Serializable
data class PokemonFormSprites(
    @SerialName("front_default") val frontDefault: String?,
    @SerialName("front_shiny") val frontShiny: String?,
    @SerialName("back_default") val backDefault: String?,
    @SerialName("back_shiny") val backShiny: String?,
)