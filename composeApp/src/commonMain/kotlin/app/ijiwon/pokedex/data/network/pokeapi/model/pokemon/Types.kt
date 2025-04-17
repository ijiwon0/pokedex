package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    val id: Int,
    val name: String,
    @SerialName("damage_relations") val damageRelations: TypeRelations,
    @SerialName("past_damage_relations") val pastDamageRelations: List<TypeRelationsPast>,
    @SerialName("game_indices") val gameIndices: List<GenerationGameIndex>,
    val generation: NamedApiResource,
    @SerialName("move_damage_class") val moveDamageClass: NamedApiResource?,
    val names: List<Name>,
    val pokemon: List<TypePokemon>,
    val moves: List<NamedApiResource>
)

@Serializable
data class TypeRelations(
    @SerialName("no_damage_to") val noDamageTo: List<NamedApiResource>,
    @SerialName("half_damage_to") val halfDamageTo: List<NamedApiResource>,
    @SerialName("double_damage_to") val doubleDamageTo: List<NamedApiResource>,
    @SerialName("no_damage_from") val noDamageFrom: List<NamedApiResource>,
    @SerialName("half_damage_from") val halfDamageFrom: List<NamedApiResource>,
    @SerialName("double_damage_from") val doubleDamageFrom: List<NamedApiResource>,
)

@Serializable
data class TypeRelationsPast(
    val generation: NamedApiResource,
    @SerialName("damage_relations") val damageRelations: TypeRelations,
)

@Serializable
data class TypePokemon(
    val slot: Int,
    val pokemon: NamedApiResource
)

@Serializable
data class GenerationGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedApiResource,
)