package app.ijiwon.pokedex.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import coil3.PlatformContext

actual fun platformDatabaseBuilder(
    context: PlatformContext
): RoomDatabase.Builder<PokedexDatabase> = Room.databaseBuilder<PokedexDatabase>(context = context, name = "pokedex.db")