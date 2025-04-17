package app.ijiwon.pokedex.features.items

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ItemsScreen(
    onItemClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ItemsViewModel = koinViewModel(),
) {
    Content(modifier)
}

@Composable
private fun Content(modifier: Modifier = Modifier) {
    Box(modifier)
}