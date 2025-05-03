package app.ijiwon.pokedex.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.SQLiteDriver
import androidx.sqlite.execSQL
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
    version = 2,
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
    .setDriver(driver)
    .setQueryCoroutineContext(Dispatchers.IO)
    .addMigrations(MIGRATION_1_2)
    .fallbackToDestructiveMigration(true)
    .build()

internal val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE pokemon ADD COLUMN isFavorite INTEGER NOT NULL DEFAULT 0")
    }
}