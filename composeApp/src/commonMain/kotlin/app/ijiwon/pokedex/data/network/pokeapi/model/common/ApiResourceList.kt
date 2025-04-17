package app.ijiwon.pokedex.data.network.pokeapi.model.common

data class ApiResourceList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ApiResource>,
)

