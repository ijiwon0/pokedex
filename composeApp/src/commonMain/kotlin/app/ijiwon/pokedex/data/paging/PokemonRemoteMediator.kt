package app.ijiwon.pokedex.data.paging

import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import app.ijiwon.pokedex.data.database.dao.PokemonDao
import app.ijiwon.pokedex.data.database.model.PokemonEntity
import app.ijiwon.pokedex.data.network.pokeapi.PokeApi
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.Pokemon
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.PokemonSpecies
import app.ijiwon.pokedex.data.paging.mapper.toPokemonEntity
import app.ijiwon.pokedex.utils.log.Timber
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO : Singleton + DI
class PokemonRemoteMediator(
    private val httpClient: HttpClient,
    private val pokeApi: PokeApi,
    private val pokemonDao: PokemonDao,
) : RemoteMediator<Int, PokemonEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>,
    ): MediatorResult = withContext(Dispatchers.IO) {
        val offset = when (loadType) {
            LoadType.REFRESH -> ZERO_OFFSET

            LoadType.PREPEND -> return@withContext MediatorResult.Success(endOfPaginationReached = true)

            LoadType.APPEND -> state.lastItemOrNull()
                ?.id
                ?: ZERO_OFFSET
        }

        try {
            val response = pokeApi.getNamedResourceList("pokemon", offset, PAGE_SIZE)

            val pokemons = response.results.map {
                async {
                    runCatching {
                        getPokemon(it.name)
                    }.onFailure { exception ->
                        Timber.d("getPokemon(${it.name})", exception)
                    }.getOrNull()
                }
            }.awaitAll()
                .filterNotNull()

            launch {
                val pokemonSpecies = pokemons.map { pokemon ->
                    async {
                        runCatching {
                            getPokemonSpecies(pokemon.species.name)
                        }.onFailure { exception ->
                            Timber.d("getPokemonSpecies(${pokemon.species.name})", exception)
                        }.getOrNull()
                    }
                }.awaitAll()
                    .filterNotNull()
            }

            pokemonDao.insertAll(pokemons.map(::toPokemonEntity))

            MediatorResult.Success(endOfPaginationReached = (response.next == null))
        } catch (exception: Exception) {
            Timber.d("PokemonRemoteMediator.load($loadType, $state)", exception)

            MediatorResult.Error(exception)
        }
    }

    private suspend fun getPokemon(name: String): Pokemon? = runCatching {
        pokeApi.getPokemon(name)
    }.onFailure { exception ->
        Timber.d(name, exception)
    }.getOrNull()

    private suspend fun getPokemonSpecies(name: String): PokemonSpecies? = runCatching {
        pokeApi.getPokemonSpecies(name)
    }.onFailure { exception ->
        Timber.d(name, exception)
    }.getOrNull()

    companion object {
        internal const val PAGE_SIZE = 25
        private const val ZERO_OFFSET = 0
    }
}