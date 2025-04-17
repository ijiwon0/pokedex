package app.ijiwon.pokedex.data.di

import app.ijiwon.pokedex.data.network.pokeapi.PokeApi
import app.ijiwon.pokedex.data.network.pokeapi.createPokeApi
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

expect fun createHttpClient(
    block: HttpClientConfig<*>.() -> Unit
): HttpClient

internal val NetworkModule = module {
    single<Json> {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

    single<HttpClient> {
        HttpClient {
            expectSuccess = true

            install(ContentNegotiation) {
                json(get<Json>())

                register(ContentType.Any, KotlinxSerializationConverter(get<Json>()))
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.d(message, tag = "pokeapi")
                    }
                }

                level = LogLevel.ALL
            }

            install(DefaultRequest) {
                contentType(ContentType.Application.Json)
            }
        }
    }

    single<Ktorfit> {
        Ktorfit.Builder()
            .baseUrl(PokeApi.BASE_URL)
            .httpClient(get<HttpClient>())
            .build()
    }

    single<PokeApi> {
        get<Ktorfit>().createPokeApi()
    }
}