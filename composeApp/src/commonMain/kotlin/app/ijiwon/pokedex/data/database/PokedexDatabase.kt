package app.ijiwon.pokedex.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.SQLiteDriver
import app.ijiwon.pokedex.data.database.converter.TypeConverter
import app.ijiwon.pokedex.data.database.dao.PokemonDao
import app.ijiwon.pokedex.data.database.model.PokemonEntity
import coil3.PlatformContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [PokemonEntity::class],
    version = 2,
)
@TypeConverters(TypeConverter::class)
@ConstructedBy(PokedexDatabaseConstructor::class)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
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