package app.ijiwon.pokedex.data.network.pokeapi.model.common

import kotlinx.serialization.Serializable

@Serializable
data class NamedApiResourceList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedApiResource>,
)