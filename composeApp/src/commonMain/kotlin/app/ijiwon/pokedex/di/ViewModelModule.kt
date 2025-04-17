package app.ijiwon.pokedex.di

import app.ijiwon.pokedex.features.items.ItemsViewModel
import app.ijiwon.pokedex.features.pokedex.PokedexViewModel
import app.ijiwon.pokedex.features.pokemon.PokemonViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelModule = module {
    viewModelOf(::PokedexViewModel)

    viewModel<PokemonViewModel> { parameters ->
        PokemonViewModel(id = parameters.get())
    }

    viewModelOf(::ItemsViewModel)
}