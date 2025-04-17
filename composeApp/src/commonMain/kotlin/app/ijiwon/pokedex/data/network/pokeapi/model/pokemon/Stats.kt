package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.ApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val id: Int,
    val name: String,
    @SerialName("game_index") val gameIndex: Int,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("affecting_moves") val affectingMoves: MoveStatAffectSets,
    @SerialName("affecting_natures") val affectingNatures: NatureStatAffectSets,
    val characteristics: List<ApiResource>,
    @SerialName("move_damage_class") val moveDamageClass: NamedApiResource?,
    val names: List<Name>,
)

@Serializable
data class MoveStatAffectSets(
    val increase: List<MoveStatAffect>,
    val decrease: List<MoveStatAffect>
)

@Serializable
data class MoveStatAffect(
    val change: Int,
    val move: NamedApiResource
)

@Serializable
data class NatureStatAffectSets(
    val increase: List<NamedApiResource>,
    val decrease: List<NamedApiResource>
)