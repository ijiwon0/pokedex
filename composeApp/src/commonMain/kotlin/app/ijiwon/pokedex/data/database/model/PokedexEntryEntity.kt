package app.ijiwon.pokedex.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.ijiwon.pokedex.model.PokemonType

@Entity(tableName = "pokedex_entry")
data class PokedexEntryEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val types: List<PokemonType>,
    val artworkUrl: String,
)