package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val name: String,
    val language: NamedApiResource
)