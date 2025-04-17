package app.ijiwon.pokedex.data.network.pokeapi.model.common

data class Language(
    val id: Int,
    val name: String,
    val official: Boolean,
    val iso639: String,
    val iso3166: String,
    val names: List<Name>,
)
