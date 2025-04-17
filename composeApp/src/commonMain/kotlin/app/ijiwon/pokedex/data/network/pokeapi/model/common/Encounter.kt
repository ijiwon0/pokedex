package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Encounter(
    @SerialName("min_level")
    val minLevel: Int,
    @SerialName("max_level")
    val maxLevel: Int,
    @SerialName("condition_values")
    val conditionValues: List<NamedApiResource>,
    val chance: Int,
    val method: NamedApiResource,
)
