package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Effect(
    val effect: String,
    val language: NamedApiResource,
)
