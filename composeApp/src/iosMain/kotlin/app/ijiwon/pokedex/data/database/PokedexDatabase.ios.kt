package app.ijiwon.pokedex.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import coil3.PlatformContext
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

val documentDirectory: NSURL?
    get() = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        null,
        false,
        null,
    )

actual fun platformDatabaseBuilder(
    context: PlatformContext
): RoomDatabase.Builder<PokedexDatabase> =
    Room.databaseBuilder<PokedexDatabase>(name = documentDirectory?.path.plus("/pokedex.db"))