package app.ijiwon.pokedex.di

import app.ijiwon.pokedex.data.di.DataModule
import org.koin.dsl.KoinAppDeclaration

val koinAppDeclaration: KoinAppDeclaration = {
    modules(
        DataModule,
        ViewModelModule,
        platformModule(),
    )
}