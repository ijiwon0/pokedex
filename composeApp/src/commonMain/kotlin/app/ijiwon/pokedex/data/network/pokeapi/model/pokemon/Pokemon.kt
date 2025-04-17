package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VersionGameIndex
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    @SerialName("base_experience") val baseExperience: Int,
    val height: Int,
    @SerialName("is_default") val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbility>,
    val forms: List<NamedApiResource>,
    @SerialName("game_indices") val gameIndices: List<VersionGameIndex>,
    @SerialName("held_items") val heldItems: List<PokemonHeldItem>,
    @SerialName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<PokemonMove>,
    @SerialName("past_types") val pastTypes: List<PokemonTypePast>,
    val sprites: PokemonSprites,
    val cries: PokemonCries,
    val species: NamedApiResource,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
) {
    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

    val showdownUrl: String?
        get() = sprites.other?.showdown?.frontDefault
}

@Serializable
data class PokemonAbility(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val ability: NamedApiResource,
)

@Serializable
data class PokemonType(
    val slot: Int,
    val type: NamedApiResource
)

@Serializable
data class PokemonTypePast(
    val generation: NamedApiResource,
    val types: List<PokemonType>,
)

@Serializable
data class PokemonHeldItem(
    val item: NamedApiResource,
    @SerialName("version_details") val versionDetails: List<PokemonHeldItemVersion>
)

@Serializable
data class PokemonHeldItemVersion(
    val version: NamedApiResource,
    val rarity: Int,
)

@Serializable
data class PokemonMove(
    val move: NamedApiResource,
    @SerialName("version_group_details") val versionGroupDetails: List<PokemonMoveVersion>,
)

@Serializable
data class PokemonMoveVersion(
    @SerialName("move_learn_method") val moveLearnMethod: NamedApiResource,
    @SerialName("version_group") val versionGroup: NamedApiResource,
    @SerialName("level_learned_at") val levelLearnedAt: Int,
)

/**
 * @param stat The stat the Pokémon has.
 * @param effort The effort points (EV) the Pokémon has in the stat.
 * @param baseState The base value of the stat.
 */
@Serializable
data class PokemonStat(
    val stat: NamedApiResource,
    val effort: Int,
    @SerialName("base_stat") val baseState: Int,
)

@Serializable
data class PokemonSprites(
    @SerialName("front_default") val frontDefault: String?,
    @SerialName("front_shiny") val frontShiny: String?,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
    @SerialName("back_default") val backDefault: String?,
    @SerialName("back_shiny") val backShiny: String?,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    val other: PokemonSpritesOther? = null,
)

@Serializable
data class PokemonSpritesOther(
    val showdown: PokemonSprites? = null
)

@Serializable
data class PokemonCries(
    val latest: String,
    val legacy: String,
)