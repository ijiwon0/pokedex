package app.ijiwon.pokedex.features.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.ijiwon.pokedex.designsystem.component.ActivityIndicator
import app.ijiwon.pokedex.designsystem.theme.White
import app.ijiwon.pokedex.model.PokedexEntry
import app.ijiwon.pokedex.ui.paging.LazyPagingItems
import app.ijiwon.pokedex.ui.paging.collectAsLazyPagingItems
import app.ijiwon.pokedex.ui.pokedex.PokedexListItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PokedexScreen(
    onPokemonClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokedexViewModel = koinViewModel(),
) {
    val pokemons = viewModel.pokedexEntries.collectAsLazyPagingItems()

    PokedexScreen(
        pokemons,
        onPokemonClick = { pokemon ->
            onPokemonClick(pokemon.id)
        },
        modifier,
    )
}

@Composable
internal fun PokedexScreen(
    pokemons: LazyPagingItems<PokedexEntry>,
    onPokemonClick: (PokedexEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isLoading by remember {
        derivedStateOf {
            pokemons.loadState.refresh == LoadState.Loading
        }
    }

    Box(
        modifier = modifier.background(White),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = with(WindowInsets.statusBars.asPaddingValues()) {
                val horizontal = 8.dp
                val top = calculateTopPadding() + calculateBottomPadding() + 72.dp
                val bottom = 16.dp

                PaddingValues(horizontal, top, horizontal, bottom)
            },
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(pokemons.itemCount) {
                val pokemon = pokemons[it] ?: return@items

                PokedexListItem(
                    pokemon,
                    onClick = onPokemonClick,
                )
            }
        }

        when {
            isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(enabled = false, onClick = {}),
                    contentAlignment = Alignment.Center,
                ) {
                    ActivityIndicator()
                }
            }
        }
    }
}