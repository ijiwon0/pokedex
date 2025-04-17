package app.ijiwon.pokedex.data.database.converter

import androidx.room.TypeConverter
import app.ijiwon.pokedex.data.database.model.NameEntity
import app.ijiwon.pokedex.data.database.model.PokemonSpeciesVarietyEntity
import app.ijiwon.pokedex.model.PokemonType
import io.ktor.serialization.kotlinx.json.DefaultJson

object TypeConverter {

    private val json = DefaultJson

    @TypeConverter
    fun fromPokemonTypes(types: List<PokemonType>): String =
        json.encodeToString(types)

    @TypeConverter
    fun toPokemonTypes(types: String): List<PokemonType> =
        json.decodeFromString(types)

    @TypeConverter
    fun fromNames(names: List<NameEntity>): String =
        json.encodeToString(names)

    @TypeConverter
    fun toNames(names: String): List<NameEntity> =
        json.decodeFromString(names)

    @TypeConverter
    fun fromVarieties(varieties: List<PokemonSpeciesVarietyEntity>): String =
        json.encodeToString(varieties)

    @TypeConverter
    fun toVarieties(varieties: String): List<PokemonSpeciesVarietyEntity> =
        json.decodeFromString(varieties)
}