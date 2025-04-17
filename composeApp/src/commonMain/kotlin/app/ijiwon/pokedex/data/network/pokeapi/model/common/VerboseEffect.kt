package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerboseEffect(
    val effect: String,
    @SerialName("short_effect")
    val shortEffect: String,
    val language: NamedApiResource,
)
