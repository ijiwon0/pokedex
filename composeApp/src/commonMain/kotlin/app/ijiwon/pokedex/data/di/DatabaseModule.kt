package app.ijiwon.pokedex.data.di

import androidx.sqlite.SQLiteDriver
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import app.ijiwon.pokedex.data.database.PokedexDatabase
import app.ijiwon.pokedex.data.database.buildDatabase
import app.ijiwon.pokedex.data.database.dao.EvolutionChainDao
import app.ijiwon.pokedex.data.database.dao.PokedexDao
import app.ijiwon.pokedex.data.database.dao.PokemonDao
import org.koin.dsl.module

val DatabaseModule = module {
    single<SQLiteDriver> {
        BundledSQLiteDriver()
    }

    single<PokedexDatabase> {
        buildDatabase(get(), get())
    }

    single<PokedexDao> {
        get<PokedexDatabase>().pokedexDao()
    }

    single<PokemonDao> {
        get<PokedexDatabase>().pokemonDao()
    }

    single<EvolutionChainDao> {
        get<PokedexDatabase>().evolutionChainDao()
    }
}