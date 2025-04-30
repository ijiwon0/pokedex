package app.ijiwon.pokedex.data.database.converter

import androidx.room.TypeConverter
import app.ijiwon.pokedex.model.EvolutionChain
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.model.PokemonType
import kotlinx.serialization.json.Json

object TypeConverter {

    private val Json: Json =
        Json {
            isLenient = true
            allowStructuredMapKeys = true
        }

    @TypeConverter
    fun fromPokemonTypes(types: List<PokemonType>): String =
        Json.encodeToString(types)

    @TypeConverter
    fun toPokemonTypes(types: String): List<PokemonType> =
        Json.decodeFromString(types)

    @TypeConverter
    fun fromVarieties(varieties: List<PokedexEntry>): String =
        Json.encodeToString(varieties)

    @TypeConverter
    fun toVarieties(varieties: String): List<PokedexEntry> =
        Json.decodeFromString(varieties)

    @TypeConverter
    fun fromEvolutionChainNodes(nodes: List<EvolutionChain.Node>) =
        Json.encodeToString(nodes)

    @TypeConverter
    fun toEvolutionChainNodes(nodes: String): List<EvolutionChain.Node> =
        Json.decodeFromString(nodes)
}