package app.ijiwon.pokedex.model

data class Pokemon(
    val id: Int,
    val name: String,
    val names: List<Name> = emptyList(),
    val imageUrl: String,
    val showdownUrl: String?,
    val types: List<PokemonType>,
    val stats: PokemonStats,
)


data class Name(val name: String, val language: String)

data class PokemonSpecies(
    val id: Int,
    val name: String,
)

data class EvolutionChain(
    val id: Int,

)