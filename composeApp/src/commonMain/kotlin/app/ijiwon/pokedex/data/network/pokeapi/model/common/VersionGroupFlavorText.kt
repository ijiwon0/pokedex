package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGroupFlavorText(
    val text: String,
    val language: NamedApiResource,
    @SerialName("version_group")
    val versionGroup: NamedApiResource,
)
