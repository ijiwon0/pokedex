package app.ijiwon.pokedex.features.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ijiwon.pokedex.domain.repository.PokemonRepository
import app.ijiwon.pokedex.model.Pokemon
import app.ijiwon.pokedex.utils.coroutines.flow.WhileSubscribedOrRetained
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class PokemonDetailsViewModel(
    private val id: Int,
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {

    val uiState = flow {
        emit(PokemonDetailsUiState.Loading)

        val pokemon = pokemonRepository.getPokemon(id)

        emit(PokemonDetailsUiState.Success(pokemon))
    }.catch {
        emit(PokemonDetailsUiState.Error(it.message ?: "Sorry :("))
    }.stateIn(viewModelScope, WhileSubscribedOrRetained, PokemonDetailsUiState.Loading)
}

sealed interface PokemonDetailsUiState {
    data object Loading : PokemonDetailsUiState
    data class Success(val pokemon: Pokemon) : PokemonDetailsUiState
    data class Error(val message: String) : PokemonDetailsUiState
}