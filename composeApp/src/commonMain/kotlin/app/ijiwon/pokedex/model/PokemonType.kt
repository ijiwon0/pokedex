package app.ijiwon.pokedex.model

import kotlinx.serialization.Serializable

// To Use Enum Serializer on Kotlin/Native
@Serializable
enum class PokemonType {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY,
    STELLAR,
    SHADOW;
}