package app.ijiwon.pokedex.data.mapper

import androidx.paging.PagingData
import androidx.paging.map
import app.ijiwon.pokedex.data.database.model.PokedexEntryEntity
import app.ijiwon.pokedex.graphql.GetPokedexEntriesQuery.Pokemon_v2_pokemonspecy
import app.ijiwon.pokedex.graphql.GetPokedexEntriesQuery.Pokemon_v2_pokemontype
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.model.PokemonType

internal fun toPokedexEntryEntity(
    specy: Pokemon_v2_pokemonspecy
): PokedexEntryEntity = with(specy) {
    val name = pokemon_v2_pokemonspeciesnames[0].name

    val types = pokemon_v2_pokemons[0]
        .pokemon_v2_pokemontypes
        .map(::toPokemonType)

    val artworkUrl = artworkUrl(id)

    PokedexEntryEntity(id, name, types, artworkUrl)
}

private fun toPokemonType(
    type: Pokemon_v2_pokemontype
) = with(type) {
    requireNotNull(pokemon_v2_type)

    val name = pokemon_v2_type.name
        .uppercase()

    PokemonType.valueOf(name)
}

internal fun toPokedexEntry(
    data: PagingData<PokedexEntryEntity>
) = data.map { entity ->
    with(entity) {
        PokedexEntry(id, artworkUrl, name, types)
    }
}