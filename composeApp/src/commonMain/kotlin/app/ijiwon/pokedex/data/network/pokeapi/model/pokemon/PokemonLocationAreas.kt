package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import app.ijiwon.pokedex.data.network.pokeapi.model.common.VersionEncounterDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationAreaEncounter(
    @SerialName("location_area") val locationArea: NamedApiResource,
    @SerialName("version_details") val versionDetails: List<VersionEncounterDetail>,
)