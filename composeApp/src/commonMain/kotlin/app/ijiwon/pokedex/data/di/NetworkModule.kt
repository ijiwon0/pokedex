package app.ijiwon.pokedex.data.di

import com.apollographql.apollo.ApolloClient
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import org.koin.dsl.module

internal val NetworkModule = module {
    single<ApolloClient> {
        ApolloClient.Builder()
            .serverUrl("https://beta.pokeapi.co/graphql/v1beta")
            .build()
    }
}