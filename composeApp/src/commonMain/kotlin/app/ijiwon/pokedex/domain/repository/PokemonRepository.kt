package app.ijiwon.pokedex.domain.repository

import androidx.paging.PagingData
import app.ijiwon.pokedex.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getAllPokemons(): Flow<PagingData<Pokemon>>

    suspend fun getPokemon(identifier: String): Pokemon
}