package app.ijiwon.pokedex.data.paging

import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import app.ijiwon.pokedex.data.database.dao.PokedexDao
import app.ijiwon.pokedex.data.database.model.PokedexEntryEntity
import app.ijiwon.pokedex.data.mapper.toPokedexEntryEntity
import app.ijiwon.pokedex.graphql.GetPokedexEntriesQuery
import app.ijiwon.pokedex.utils.log.Timber
import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class PokedexEntryRemoteMediator(
    private val apolloClient: ApolloClient,
    private val dao: PokedexDao,
) : RemoteMediator<Int, PokedexEntryEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokedexEntryEntity>,
    ): MediatorResult = withContext(Dispatchers.IO) {
        val offset = when (loadType) {
            LoadType.REFRESH -> {
                0
            }

            LoadType.PREPEND -> {
                return@withContext MediatorResult.Success(endOfPaginationReached = true)
            }

            LoadType.APPEND -> {
                state.pages.sumOf { it.data.size }
            }
        }

        try {
            val query = GetPokedexEntriesQuery.Builder()
                .limit(PAGE_SIZE)
                .offset(offset)
                .build()

            val response = apolloClient.query(query)
                .execute()

            val entries = response.dataOrThrow()
                .pokemon_v2_pokemonspecies
                .map(::toPokedexEntryEntity)

            dao.insertAll(entries)

            MediatorResult.Success(endOfPaginationReached = entries.size < PAGE_SIZE)
        } catch (exception: Exception) {
            Timber.d(String(), exception)

            MediatorResult.Error(exception)
        }
    }

    companion object {
        const val PAGE_SIZE = 50
    }
}