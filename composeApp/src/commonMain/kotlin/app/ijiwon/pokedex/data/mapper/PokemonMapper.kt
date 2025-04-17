package app.ijiwon.pokedex.data.mapper

import app.ijiwon.pokedex.data.database.model.PokemonEntity
import app.ijiwon.pokedex.model.Pokemon
import app.ijiwon.pokedex.model.PokemonStats

internal fun PokemonEntity.toPokemon(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        imageUrl = imageUrl,
        showdownUrl = showdownUrl,
        types = types,
        stats = with(stats) {
            PokemonStats(
                hp = hp,
                attack = attack,
                defense = defense,
                specialAttack = specialAttack,
                specialDefense = specialDefense,
                speed = speed,
            )
        },
    )
}