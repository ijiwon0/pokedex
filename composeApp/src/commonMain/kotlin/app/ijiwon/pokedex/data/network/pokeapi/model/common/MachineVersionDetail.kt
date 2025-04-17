package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MachineVersionDetail(
    val machine: ApiResource,
    @SerialName("version_group")
    val versionGroup: NamedApiResource,
)
