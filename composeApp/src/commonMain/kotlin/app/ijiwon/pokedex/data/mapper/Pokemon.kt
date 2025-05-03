package app.ijiwon.pokedex.data.mapper

import app.ijiwon.pokedex.data.database.model.EvolutionChainEntity
import app.ijiwon.pokedex.data.database.model.PokemonEntity
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemon
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemon2
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemonstat
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemontype
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemontype2
import app.ijiwon.pokedex.model.EvolutionChain
import app.ijiwon.pokedex.model.Kilogram
import app.ijiwon.pokedex.model.Meter
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.model.Pokemon
import app.ijiwon.pokedex.model.PokemonType

internal fun Pokemon_v2_pokemon.toPokemonEntity(): PokemonEntity {
    requireNotNull(pokemon_v2_pokemonspecy)

    val specyNames = pokemon_v2_pokemonspecy.pokemon_v2_pokemonspeciesnames

    val specyNameEn = specyNames.first { it.pokemon_v2_language?.name == "en" }
    val specyNameJa = specyNames.first { it.pokemon_v2_language?.name == "ja-Hrkt" }

    val name = specyNameEn.name
    val genus = specyNameEn.genus
    val nameJa = specyNameJa.name

    val types = pokemon_v2_pokemontypes.map(::toPokemonType)

    val stats = toPokemonEntityStats(pokemon_v2_pokemonstats)

    val artworkUrl = artworkUrl(id)

    val showdownUrl = showdownUrl(id)

    return with(pokemon_v2_pokemonspecy) {
        val varieties = pokemon_v2_pokemons.map(::toPokemonVariety)

        PokemonEntity(
            id = id,
            name = name,
            nameJa = nameJa,
            genus = genus,
            baseExperience = base_experience ?: 0,
            height = height ?: 0,
            weight = weight ?: 0,
            types = types,
            stats = stats,
            artworkUrl = artworkUrl,
            showdownUrl = showdownUrl,
            varieties = varieties,
            baseHappiness = base_happiness ?: 0,
            captureRate = capture_rate ?: 0,
            genderRate = gender_rate ?: 0,
            hasGenderDifferences = has_gender_differences,
            isBaby = is_baby,
            isLegendary = is_legendary,
            isMythical = is_mythical,
            evolutionChainId = pokemon_v2_evolutionchain?.id,
        )
    }
}

private fun toPokemonType(type: Pokemon_v2_pokemontype) = with(type) {
    requireNotNull(pokemon_v2_type)

    pokemon_v2_type
        .name
        .uppercase()
        .let(PokemonType::valueOf)
}

private fun toPokemonEntityStats(
    stats: List<Pokemon_v2_pokemonstat>,
): PokemonEntity.Stats {
    var hp = 0
    var attack = 0
    var defense = 0
    var specialAttack = 0
    var specialDefense = 0
    var speed = 0

    stats.forEach {
        val name = it.pokemon_v2_stat?.name
        val value = it.base_stat

        when (name) {
            "hp" -> hp = value
            "attack" -> attack = value
            "defense" -> defense = value
            "special-attack" -> specialAttack = value
            "special-defense" -> specialDefense = value
            "speed" -> speed = value
        }
    }

    return PokemonEntity.Stats(
        hp,
        attack,
        defense,
        specialAttack,
        specialDefense,
        speed,
    )
}

internal fun artworkUrl(id: Int) =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

internal fun showdownUrl(id: Int) =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/$id.gif"

private fun toPokemonVariety(
    variety: Pokemon_v2_pokemon2
) = with(variety) {
    val artworkUrl = artworkUrl(id)

    val types = pokemon_v2_pokemontypes.map(::toPokemonType)

    PokedexEntry(id, artworkUrl, name, types)
}

private fun toPokemonType(type: Pokemon_v2_pokemontype2) = with(type) {
    requireNotNull(pokemon_v2_type)

    pokemon_v2_type
        .name
        .uppercase()
        .let(PokemonType::valueOf)
}

fun PokemonEntity.toPokemon(evolutionChain: EvolutionChainEntity?): Pokemon {
    @Suppress("NAME_SHADOWING")
    val evolutionChain = evolutionChain?.let {
        EvolutionChain(id, it.pokemons)
    }

    return Pokemon(
        id = id,
        name = name,
        nameJa = nameJa,
        genus = genus,
        artworkUrl = artworkUrl,
        showdownUrl = showdownUrl,
        types = types,
        stats = with(stats) {
            Pokemon.Stats(
                Pokemon.Stat(Pokemon.StatType.HP, hp),
                Pokemon.Stat(Pokemon.StatType.ATTACK, attack),
                Pokemon.Stat(Pokemon.StatType.DEFENSE, defense),
                Pokemon.Stat(Pokemon.StatType.SPECIAL_ATTACK, specialAttack),
                Pokemon.Stat(Pokemon.StatType.SPECIAL_DEFENSE, specialDefense),
                Pokemon.Stat(Pokemon.StatType.SPEED, speed),
            )
        },
        height = Meter(height / 10F),
        weight = Kilogram(weight / 10F),
        baseExperience = baseExperience,
        baseHappiness = baseHappiness,
        captureRate = captureRate,
        genderRate = genderRate,
        hasGenderDifferences = hasGenderDifferences,
        isBaby = isBaby,
        isLegendary = isLegendary,
        isMythical = isMythical,
        evolutionChain = evolutionChain,
        varieties = varieties,
    )
}