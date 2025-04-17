package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.Serializable

@Serializable
data class NamedApiResource(
    val name: String,
    val url: String,
)

