package app.ijiwon.pokedex.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.SQLiteDriver
import app.ijiwon.pokedex.data.database.converter.TypeConverter
import app.ijiwon.pokedex.data.database.dao.EvolutionChainDao
import app.ijiwon.pokedex.data.database.dao.PokedexDao
import app.ijiwon.pokedex.data.database.dao.PokemonDao
import app.ijiwon.pokedex.data.database.model.EvolutionChainEntity
import app.ijiwon.pokedex.data.database.model.PokedexEntryEntity
import app.ijiwon.pokedex.data.database.model.PokemonEntity
import coil3.PlatformContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [
        PokedexEntryEntity::class,
        PokemonEntity::class,
        EvolutionChainEntity::class
    ],
    version = 1,
)
@TypeConverters(TypeConverter::class)
@ConstructedBy(PokedexDatabaseConstructor::class)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokedexDao(): PokedexDao
    abstract fun pokemonDao(): PokemonDao
    abstract fun evolutionChainDao(): EvolutionChainDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object PokedexDatabaseConstructor : RoomDatabaseConstructor<PokedexDatabase> {
    override fun initialize(): PokedexDatabase
}

expect fun platformDatabaseBuilder(context: PlatformContext): RoomDatabase.Builder<PokedexDatabase>

internal fun buildDatabase(
    builder: RoomDatabase.Builder<PokedexDatabase>,
    driver: SQLiteDriver,
): PokedexDatabase = builder
    .fallbackToDestructiveMigration(true)
    .setDriver(driver)
    .setQueryCoroutineContext(Dispatchers.IO)
    .build()