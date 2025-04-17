package app.ijiwon.pokedex.di

import app.ijiwon.pokedex.data.di.DataModule
import app.ijiwon.pokedex.domain.di.DomainModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

val koinAppDeclaration: KoinAppDeclaration = {
    modules(
        DataModule,
        DomainModule,
        ViewModelModule,
        platformModule(),
    )
}

fun initKoin() {
    startKoin(koinAppDeclaration)
}