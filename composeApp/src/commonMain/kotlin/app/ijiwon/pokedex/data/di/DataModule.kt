package app.ijiwon.pokedex.data.di

import org.koin.dsl.module

val DataModule = module {
    includes(NetworkModule, DatabaseModule, RepositoryModule)
}