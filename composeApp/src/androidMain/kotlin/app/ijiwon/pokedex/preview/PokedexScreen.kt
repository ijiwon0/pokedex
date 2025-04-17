package app.ijiwon.pokedex.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import app.ijiwon.pokedex.core.designsystem.theme.PokedexTheme
import app.ijiwon.pokedex.core.ui.paging.collectAsLazyPagingItems
import app.ijiwon.pokedex.features.pokedex.PokedexScreen
import app.ijiwon.pokedex.model.Pokemon
import kotlinx.coroutines.flow.flowOf

@Preview
@Composable
private fun PokedexScreenPreview() {
    PokedexTheme {
        val pokemons = flowOf(
            PagingData.empty<Pokemon>(
                sourceLoadStates = LoadStates(
                    refresh = LoadState.Loading,
                    prepend = LoadState.Loading,
                    append = LoadState.Loading,
                )
            )
        ).collectAsLazyPagingItems()
        
        PokedexScreen(pokemons, onPokemonClick = {})
    }
}