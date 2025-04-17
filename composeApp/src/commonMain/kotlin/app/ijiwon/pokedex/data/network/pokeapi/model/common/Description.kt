package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Description(
    val description: String,
    val language: NamedApiResource,
)
