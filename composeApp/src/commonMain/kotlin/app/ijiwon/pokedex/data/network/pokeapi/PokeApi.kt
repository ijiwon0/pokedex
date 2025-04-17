package app.ijiwon.pokedex.data.network.pokeapi

import app.ijiwon.pokedex.data.network.pokeapi.model.Berry
import app.ijiwon.pokedex.data.network.pokeapi.model.EvolutionChain
import app.ijiwon.pokedex.data.network.pokeapi.model.Item
import app.ijiwon.pokedex.data.network.pokeapi.model.Move
import app.ijiwon.pokedex.data.network.pokeapi.model.Pokedex
import app.ijiwon.pokedex.data.network.pokeapi.model.common.ApiResourceList
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResourceList
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.Pokemon
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.PokemonSpecies
import app.ijiwon.pokedex.data.network.pokeapi.model.pokemon.PokemonType
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

interface PokeApi {

    @GET(Endpoints.BERRY)
    suspend fun getBerry(@Path("identifier") identifier: String): Berry

    @GET(Endpoints.EVOLUTION_CHAIN)
    suspend fun getEvolutionChain(@Path("id") id: Int): EvolutionChain

    @GET(Endpoints.ITEM)
    suspend fun getItem(@Path("identifier") identifier: String): Item

    @GET(Endpoints.MOVE)
    suspend fun getMove(@Path("identifier") identifier: String): Move

    @GET(Endpoints.POKEMON)
    suspend fun getPokemon(@Path("identifier") identifier: String): Pokemon

    @GET(Endpoints.POKEMON_SPECIES)
    suspend fun getPokemonSpecies(@Path("identifier") identifier: String): PokemonSpecies

    @GET(Endpoints.POKEMON_TYPE)
    suspend fun getPokemonType(@Path("identifier") identifier: String): PokemonType

    @GET(Endpoints.POKEDEX)
    suspend fun getPokedex(@Path("identifier") identifier: String): Pokedex

    @GET(Endpoints.RESOURCE_LIST)
    suspend fun getNamedResourceList(
        @Path("endpoint") endpoint: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): NamedApiResourceList

    @GET(Endpoints.RESOURCE_LIST)
    suspend fun getUnnamedResourceList(
        @Path("endpoint") endpoint: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): ApiResourceList

    object Endpoints {
        const val RESOURCE_LIST = "{endpoint}"
        const val BERRY = "berry/{identifier}"
        const val EVOLUTION_CHAIN = "evolution-chain/{id}"
        const val POKEDEX = "pokedex/{identifier}"
        const val ITEM = "item/{identifier}"
        const val POKEMON = "pokemon/{identifier}"
        const val POKEMON_SPECIES = "pokemon-species/{identifier}"
        const val POKEMON_TYPE = "type/{identifier}"
        const val MOVE = "move/{identifier}"
    }

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}