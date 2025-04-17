package app.ijiwon.pokedex.data.paging.mapper

import app.ijiwon.pokedex.data.database.model.PokemonEntity
import app.ijiwon.pokedex.data.database.model.PokemonStatsEntity
import app.ijiwon.pokedex.model.PokemonType
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.Pokemon as NetworkPokemon
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.PokemonStat as NetworkPokemonStat
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.PokemonType as NetworkPokemonType

internal fun toPokemonEntity(
    pokemon: NetworkPokemon
): PokemonEntity = with(pokemon) {
    return PokemonEntity(
        id = id,
        name = name,
        baseExperience = baseExperience,
        height = height,
        weight = weight,
        types = types.toPokemonTypes(),
        stats = stats.toPokemonStatsEntity(),
        imageUrl = imageUrl,
        showdownUrl = showdownUrl,
    )
}

private fun List<NetworkPokemonType>.toPokemonTypes(): List<PokemonType> {
    return sortedBy {
        it.slot
    }.map {
        it.type.name
            .uppercase()
            .let(PokemonType::valueOf)
    }
}

private fun List<NetworkPokemonStat>.toPokemonStatsEntity(): PokemonStatsEntity {
    return associate { stat ->
        stat.stat.name to stat.baseState
    }.let { stats ->
        PokemonStatsEntity(
            hp = stats.getValue("hp"),
            attack = stats.getValue("attack"),
            defense = stats.getValue("defense"),
            specialAttack = stats.getValue("special-attack"),
            specialDefense = stats.getValue("special-defense"),
            speed = stats.getValue("speed"),
        )
    }
}