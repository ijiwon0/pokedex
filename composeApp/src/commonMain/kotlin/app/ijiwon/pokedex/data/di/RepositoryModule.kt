package app.ijiwon.pokedex.data.di

import app.ijiwon.pokedex.data.repository.PokemonDataRepository
import app.ijiwon.pokedex.domain.repository.PokemonRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<PokemonRepository> {
        PokemonDataRepository(get(), get(), get())
    }
}