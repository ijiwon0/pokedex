package app.ijiwon.pokedex.features.pokemon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PokemonScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = koinViewModel {
        parametersOf(id)
    },
) {

}