package app.ijiwon.pokedex.di

import androidx.room.RoomDatabase
import app.ijiwon.pokedex.data.database.PokedexDatabase
import app.ijiwon.pokedex.data.database.platformDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<RoomDatabase.Builder<PokedexDatabase>> {
        platformDatabaseBuilder(androidContext())
    }
}