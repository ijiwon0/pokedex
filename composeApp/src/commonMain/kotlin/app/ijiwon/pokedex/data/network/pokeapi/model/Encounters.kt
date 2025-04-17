package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.Serializable

@Serializable
data class EncounterMethod(
    val id: Int,
    val name: String,
    val order: Int,
    val names: List<Name>,
)

@Serializable
data class EncounterCondition(
    val id: Int,
    val name: String,
    val names: List<Name>,
    val values: List<NamedApiResource>
)

@Serializable
data class EncounterConditionValues(
    val id: Int,
    val name: String,
    val condition: NamedApiResource,
    val names: List<Name>,
)