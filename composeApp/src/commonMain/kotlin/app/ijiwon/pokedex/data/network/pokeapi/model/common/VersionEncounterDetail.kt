package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionEncounterDetail(
    val version: NamedApiResource,
    @SerialName("max_chance")
    val maxChance: Int,
    @SerialName("encounter_details")
    val encounterDetails: List<Encounter>,
)
