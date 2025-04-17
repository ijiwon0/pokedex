package app.ijiwon.pokedex.features.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import app.ijiwon.pokedex.domain.repository.PokemonRepository

class PokedexViewModel(
    pokemonRepository: PokemonRepository,
) : ViewModel() {

    val pokemons = pokemonRepository.getAllPokemons()
        .cachedIn(viewModelScope)
}