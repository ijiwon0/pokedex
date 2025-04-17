package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nature(
    val id: Int,
    val name: String,
    @SerialName("decreased_stat") val decreasedStat: NamedApiResource?,
    @SerialName("increased_stat") val increasedStat: NamedApiResource?,
    @SerialName("hates_flavor") val hatesFlavor: NamedApiResource?,
    @SerialName("likes_flavor") val likesFlavor: NamedApiResource?,
    @SerialName("pokeathlon_stat_changes") val pokeathlonStatChanges: List<NatureStatChange>,
    @SerialName("move_battle_style_preferences") val moveBattleStylePreferences: List<MoveBattleStylePreference>,
    val names: List<Name>,
)

@Serializable
data class NatureStatChange(
    @SerialName("max_change") val maxChange: Int,
    @SerialName("pokeathlon_stat") val pokeathlonStat: NamedApiResource
)

@Serializable
data class MoveBattleStylePreference(
    @SerialName("low_hp_preference") val lowHpPreference: Int,
    @SerialName("high_hp_preference") val highHpPreference: Int,
    @SerialName("move_battle_style") val moveBattleStyle: NamedApiResource,
)