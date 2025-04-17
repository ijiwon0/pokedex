package app.ijiwon.pokedex

import android.app.Application
import app.ijiwon.pokedex.data.di.DataModule
import app.ijiwon.pokedex.di.ViewModelModule
import app.ijiwon.pokedex.di.platformModule
import app.ijiwon.pokedex.domain.di.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokedexApplication)

            modules(
                DataModule,
                platformModule(),
                DomainModule,
                ViewModelModule,
            )
        }
    }
}