package app.ijiwon.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.ijiwon.pokedex.data.database.dao.EvolutionChainDao
import app.ijiwon.pokedex.data.database.dao.PokedexDao
import app.ijiwon.pokedex.data.database.dao.PokemonDao
import app.ijiwon.pokedex.data.mapper.toEvolutionChainEntity
import app.ijiwon.pokedex.data.mapper.toPokedexEntry
import app.ijiwon.pokedex.data.mapper.toPokemon
import app.ijiwon.pokedex.data.mapper.toPokemonEntity
import app.ijiwon.pokedex.data.paging.PokedexEntryRemoteMediator
import app.ijiwon.pokedex.data.paging.PokedexEntryRemoteMediator.Companion.PAGE_SIZE
import app.ijiwon.pokedex.domain.repository.PokemonRepository
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery
import app.ijiwon.pokedex.graphql.GetPokemonDetailsQuery.Pokemon_v2_pokemon
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.model.Pokemon
import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PokemonDataRepository(
    private val apolloClient: ApolloClient,
    private val pokedexDao: PokedexDao,
    private val pokemonDao: PokemonDao,
    private val evolutionChainDao: EvolutionChainDao,
) : PokemonRepository {

    private val config = PagingConfig(pageSize = PAGE_SIZE)

    private val remoteMediator = PokedexEntryRemoteMediator(apolloClient, pokedexDao)

    override fun getPokedexEntries(): Flow<PagingData<PokedexEntry>> {
        return Pager(
            config,
            remoteMediator = remoteMediator,
            pagingSourceFactory = {
                pokedexDao.getPagingSource()
            },
        ).flow
            .map(::toPokedexEntry)
    }

    override suspend fun getPokemon(id: Int): Pokemon {
        return when (val cached = pokemonDao.getById(id)) {
            null -> {
                val fetched: Pokemon_v2_pokemon = queryPokemon(id)

                val entity = fetched.toPokemonEntity().also {
                    pokemonDao.insert(it)
                }

                val evolutionChain = fetched.pokemon_v2_pokemonspecy
                    ?.pokemon_v2_evolutionchain
                    ?.let(::toEvolutionChainEntity)
                    ?.also {
                        evolutionChainDao.insert(it)
                    }

                entity.toPokemon(evolutionChain)
            }
            else -> {
                cached.evolutionChainId?.let {
                    evolutionChainDao.getById(it)
                }.let {
                    cached.toPokemon(it)
                }
            }
        }
    }

    private suspend fun queryPokemon(id: Int): Pokemon_v2_pokemon {
        val query = GetPokemonDetailsQuery.Builder()
            .id(id)
            .build()

        val response = apolloClient.query(query)
            .execute()

        return response.dataOrThrow()
            .pokemon_v2_pokemon[0]
    }
}