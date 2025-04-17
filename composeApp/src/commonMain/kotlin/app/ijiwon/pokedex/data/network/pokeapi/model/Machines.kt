package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Machine(
    val id: Int,
    val item: NamedApiResource,
    val move: NamedApiResource,
    @SerialName("version_group")
    val versionGroup: NamedApiResource,
)