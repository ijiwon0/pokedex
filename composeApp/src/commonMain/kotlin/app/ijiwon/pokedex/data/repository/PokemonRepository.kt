package app.ijiwon.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import app.ijiwon.pokedex.data.database.dao.PokemonDao
import app.ijiwon.pokedex.data.mapper.toPokemon
import app.ijiwon.pokedex.data.network.pokeapi.PokeApi
import app.ijiwon.pokedex.data.paging.PokemonRemoteMediator
import app.ijiwon.pokedex.domain.repository.PokemonRepository
import app.ijiwon.pokedex.model.Pokemon
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PokemonDataRepository(
    private val httpClient: HttpClient,
    private val api: PokeApi,
    private val dao: PokemonDao,
) : PokemonRepository {

    override fun getAllPokemons(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = PokemonRemoteMediator.PAGE_SIZE,
                prefetchDistance = PokemonRemoteMediator.PAGE_SIZE * 10,
            ),
            remoteMediator = PokemonRemoteMediator(httpClient, api, dao),
        ) {
            dao.pagingSource()
        }.flow.map {
            it.map { entity ->
                entity.toPokemon()
            }
        }
    }

    override suspend fun getPokemon(identifier: String): Pokemon {
        TODO()
    }
}