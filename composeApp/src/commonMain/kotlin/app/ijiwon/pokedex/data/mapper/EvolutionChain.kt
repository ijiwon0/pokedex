package app.ijiwon.pokedex.data.mapper

import app.ijiwon.pokedex.data.database.model.EvolutionChainEntity
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_evolutionchain
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemonevolution
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemonspecy1
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemontype1
import app.ijiwon.pokedex.model.EvolutionChain
import app.ijiwon.pokedex.model.EvolutionTrigger
import app.ijiwon.pokedex.model.PokemonType

internal fun toEvolutionChainEntity(
    evolutionChain: Pokemon_v2_evolutionchain
): EvolutionChainEntity? = with(evolutionChain) {
    if (pokemon_v2_pokemonspecies.size == 1) return null

    val pokemons = pokemon_v2_pokemonspecies.map(::toEvolutionChainNode)

    return EvolutionChainEntity(id, pokemons)
}

private fun toEvolutionChainNode(specy: Pokemon_v2_pokemonspecy1) = with(specy) {
    val name = pokemon_v2_pokemonspeciesnames[0].name

    val artworkUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

    val types = pokemon_v2_pokemons[0]
        .pokemon_v2_pokemontypes
        .map(::toPokemonType)

    val evolvesFrom = evolves_from_species_id

    val trigger = pokemon_v2_pokemonevolutions.getOrNull(0)
        ?.let(::toEvolutionTrigger)

    EvolutionChain.Node(id, name, artworkUrl, types, evolvesFrom, trigger)
}

private fun toPokemonType(type: Pokemon_v2_pokemontype1) = with(type) {
    pokemon_v2_type ?: throw IllegalArgumentException()

    pokemon_v2_type
        .name
        .uppercase()
        .let(PokemonType::valueOf)
}

private fun toEvolutionTrigger(evolution: Pokemon_v2_pokemonevolution) = with(evolution) {
    EvolutionTrigger(
        minAffection = min_affection,
        minBeauty = min_beauty,
        minHappiness = min_happiness,
        minLevel = min_level,
        itemName = pokemon_v2_item?.name
    )
}