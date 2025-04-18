package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlavorText(
    @SerialName("flavor_text")
    val flavorText: String,
    val language: NamedApiResource,
    val version: NamedApiResource,
)