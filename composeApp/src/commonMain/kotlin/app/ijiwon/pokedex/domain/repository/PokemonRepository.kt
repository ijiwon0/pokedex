package app.ijiwon.pokedex.domain.repository

import androidx.paging.PagingData
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokedexEntries(): Flow<PagingData<PokedexEntry>>

    suspend fun getPokemon(id: Int): Pokemon
}