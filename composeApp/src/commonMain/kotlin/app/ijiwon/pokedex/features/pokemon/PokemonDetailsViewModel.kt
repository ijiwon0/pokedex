package app.ijiwon.pokedex.features.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ijiwon.pokedex.domain.repository.PokemonRepository
import app.ijiwon.pokedex.model.Pokemon
import app.ijiwon.pokedex.utils.coroutines.flow.WhileSubscribedOrRetained
import app.ijiwon.pokedex.utils.log.Timber
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val id: Int,
    private val pokemonRepository: PokemonRepository,
) : ViewModel() {

    private val retry = MutableSharedFlow<Unit>(replay = 1)

    val uiState = retry.flatMapLatest {
        flow {
            emit(PokemonDetailsUiState.Loading)

            val pokemon = pokemonRepository.getPokemon(id)

            emit(PokemonDetailsUiState.Success(pokemon))
        }.catch {
            Timber.d(message = it.message ?: String(), it)

            emit(PokemonDetailsUiState.Error("Pokémon seems to be hiding :("))
        }
    }.stateIn(viewModelScope, WhileSubscribedOrRetained, PokemonDetailsUiState.Loading)

    init {
        retry()
    }

    fun retry() {
        viewModelScope.launch {
            retry.emit(Unit)
        }
    }
}

sealed interface PokemonDetailsUiState {
    data object Loading : PokemonDetailsUiState
    data class Success(val pokemon: Pokemon) : PokemonDetailsUiState
    data class Error(val message: String) : PokemonDetailsUiState
}