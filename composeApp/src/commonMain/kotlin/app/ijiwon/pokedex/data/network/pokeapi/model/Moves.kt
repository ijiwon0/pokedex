package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.ApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Description
import app.ijiwon.pokedex.data.network.pokeapi.model.common.MachineVersionDetail
import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VerboseEffect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Move(
    val id: Int,
    val name: String,
    val accuracy: Int?,
    @SerialName("effect_chance") val effectChance: Int?,
    @SerialName("pp") val powerPoints: Int,
    val priority: Int,
    val power: Int?,
    @SerialName("contest_combos") val contestCombos: ContestComboSets?,
    @SerialName("contest_type") val contestType: NamedApiResource,
    @SerialName("contest_effect") val contestEffect: ApiResource,
    @SerialName("damage_class") val damageClass: NamedApiResource,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffect>,
    @SerialName("effect_changes") val effectChanges: List<AbilityEffectChange>,
    @SerialName("learned_by_pokemon") val learnedByPokemon: List<NamedApiResource>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<MoveFlavorText>,
    val generation: NamedApiResource,
    val machines: List<MachineVersionDetail>,
    val meta: MoveMetaData,
    val names: List<Name>,
    @SerialName("past_values") val pastValues: List<PastMoveStatValues>,
    @SerialName("stat_changes") val statChanges: List<MoveStatChange>,
    @SerialName("super_contest_effect") val superContestEffect: ApiResource,
    val target: NamedApiResource,
    val type: NamedApiResource,
)

@Serializable
data class ContestComboSets(
    val normal: ContestComboDetail?,
    @SerialName("super") val `super`: ContestComboDetail?,
)

@Serializable
data class ContestComboDetail(
    @SerialName("use_before") val useBefore: List<NamedApiResource>?,
    @SerialName("use_after") val useAfter: List<NamedApiResource>?,
)

@Serializable
data class MoveFlavorText(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedApiResource,
    @SerialName("version_group") val versionGroup: NamedApiResource,
)

@Serializable
data class AbilityEffectChange(
    @SerialName("effect_entries") val effectEntries: List<VerboseEffect>,
    @SerialName("version_group") val versionGroup: NamedApiResource,
)

@Serializable
data class MoveMetaData(
    val ailment: NamedApiResource,
    val category: NamedApiResource,
    @SerialName("min_hits")
    val minHits: Int?,
    @SerialName("max_hits")
    val maxHits: Int?,
    @SerialName("min_turns")
    val minTurns: Int?,
    @SerialName("max_turns")
    val maxTurns: Int?,
    val drain: Int,
    val healing: Int,
    @SerialName("crit_rate")
    val critRate: Int,
    @SerialName("ailment_chance")
    val ailmentChance: Int,
    @SerialName("flinch_chance")
    val flinchChance: Int,
    @SerialName("stat_chance")
    val statChance: Int
)

@Serializable
data class MoveStatChange(
    val change: Int,
    val stat: NamedApiResource
)

@Serializable
data class PastMoveStatValues(
    val accuracy: Int?,
    @SerialName("effect_chance")
    val effectChance: Int?,
    val power: Int?,
    @SerialName("pp")
    val powerPoints: Int?,
    @SerialName("effect_entries")
    val effectEntries: List<VerboseEffect>?,
    val type: NamedApiResource?,
    @SerialName("version_group")
    val versionGroup: NamedApiResource,
)

@Serializable
data class MoveAilment(
    val id: Int,
    val name: String,
    val moves: List<NamedApiResource>,
    val names: List<Name>
)

@Serializable
data class MoveBattleStyle(
    val id: Int,
    val name: String,
    val names: List<Name>
)

@Serializable
data class MoveCategory(
    val id: Int,
    val name: String,
    val moves: List<NamedApiResource>,
    val descriptions: List<Description>
)

@Serializable
data class MoveDamageClass(
    val id: Int,
    val name: String,
    val descriptions: List<Description>,
    val moves: List<NamedApiResource>,
    val names: List<Name>
)

@Serializable
data class MoveLearnMethod(
    val id: Int,
    val name: String,
    val descriptions: List<Description>,
    val names: List<Name>,
    @SerialName("version_groups") val versionGroups: List<NamedApiResource>
)

@Serializable
data class MoveTarget(
    val id: Int,
    val name: String,
    val descriptions: List<Description>,
    val moves: List<NamedApiResource>,
    val names: List<Name>
)