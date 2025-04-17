package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGameIndex(
    @SerialName("game_index")
    val gameIndex: Int,
    val version: NamedApiResource,
)
