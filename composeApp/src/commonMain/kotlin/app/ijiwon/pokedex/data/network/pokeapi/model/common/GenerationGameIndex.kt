package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationGameIndex(
    @SerialName("game_index")
    val gameIndex: Int,
    val generation: NamedApiResource,
)
