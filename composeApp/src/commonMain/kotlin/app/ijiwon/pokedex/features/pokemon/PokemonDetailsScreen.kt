package app.ijiwon.pokedex.features.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.ijiwon.pokedex.designsystem.component.ActivityIndicator
import app.ijiwon.pokedex.designsystem.theme.Gray100
import app.ijiwon.pokedex.designsystem.theme.Gray200
import app.ijiwon.pokedex.designsystem.theme.Gray300
import app.ijiwon.pokedex.designsystem.theme.Gray50
import app.ijiwon.pokedex.designsystem.theme.Gray500
import app.ijiwon.pokedex.designsystem.theme.Gray600
import app.ijiwon.pokedex.designsystem.theme.Gray900
import app.ijiwon.pokedex.designsystem.theme.White
import app.ijiwon.pokedex.designsystem.theme.Yellow500
import app.ijiwon.pokedex.features.pokemon.section.PokemonEvolution
import app.ijiwon.pokedex.features.pokemon.section.PokemonStats
import app.ijiwon.pokedex.features.pokemon.section.PokemonVarieties
import app.ijiwon.pokedex.model.Kilogram
import app.ijiwon.pokedex.model.Meter
import app.ijiwon.pokedex.model.Pokemon
import app.ijiwon.pokedex.model.PokemonType
import app.ijiwon.pokedex.ui.error.ErrorView
import app.ijiwon.pokedex.ui.pokemon.type.PokemonTypeTag
import coil3.compose.AsyncImage
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.base_experience
import pokedex.composeapp.generated.resources.catch_rate
import pokedex.composeapp.generated.resources.chevron_left
import pokedex.composeapp.generated.resources.height
import pokedex.composeapp.generated.resources.star_filled
import pokedex.composeapp.generated.resources.star_outlined
import pokedex.composeapp.generated.resources.weight

@Composable
fun PokemonDetailsScreen(
    id: Int,
    onBackClick: () -> Unit,
    onPokemonClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailsViewModel = koinViewModel {
        parametersOf(id)
    },
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PokemonDetailsScreen(
        uiState,
        onBackClick,
        onRetryClick = viewModel::retry,
        onPokemonClick = {
            if (id != it) onPokemonClick(it)
        },
        modifier,
    )
}

@Composable
internal fun PokemonDetailsScreen(
    uiState: PokemonDetailsUiState,
    onBackClick: () -> Unit,
    onRetryClick: () -> Unit,
    onPokemonClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    },
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F7)),
        contentAlignment = Alignment.Center,
    ) {
        when (uiState) {
            PokemonDetailsUiState.Loading -> {
                ActivityIndicator()
            }
            is PokemonDetailsUiState.Error -> {
                ErrorView(uiState.message, onRetryClick)
            }
            is PokemonDetailsUiState.Success -> {
                PokemonDetailsContent(
                    pokemon = uiState.pokemon,
                    onBackClick,
                    onPokemonClick,
                )
            }
        }
    }
}

@Composable
private fun TopAppBar(
    artworkUrl: String,
    name: String,
    showPokemon: Boolean,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
            .height(52.dp),
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .size(24.dp)
                .clickable(onClick = onBackClick),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(Res.drawable.chevron_left),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Gray500,
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(if (showPokemon) 1F else 0F),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                artworkUrl,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
                    .background(Gray50, RoundedCornerShape(6.dp))
                    .border(1.dp, Gray100, RoundedCornerShape(6.dp))
                    .padding(2.dp),
                contentScale = ContentScale.Fit,
            )

            Text(
                text = name,
                color = Gray900,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            var isFavorite by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        isFavorite = !isFavorite
                    },
                contentAlignment = Alignment.Center,
            ) {

                Icon(
                    painter = painterResource(
                        if (isFavorite) {
                            Res.drawable.star_filled
                        } else {
                            Res.drawable.star_outlined
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = if (isFavorite) Yellow500 else Gray500,
                )
            }
        }
    }
}

@Composable
private fun PokemonDetailsContent(
    pokemon: Pokemon,
    onBackClick: () -> Unit,
    onPokemonClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) = with(pokemon) {
    val scrollState = rememberScrollState()

    val threshold = remember {
        mutableFloatStateOf(0F)
    }

    val showPreview by derivedStateOf {
        scrollState.canScrollBackward and (scrollState.value > threshold.value)
    }

    Column(
        modifier = modifier,
    ) {
        TopAppBar(artworkUrl, name, showPreview, onBackClick)

        if (scrollState.canScrollBackward) {
            HorizontalDivider(color = Gray100)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            PokemonProfile(
                showdownUrl,
                idLabel,
                name,
                nameJa,
                genus,
                types.toImmutableList(),
                modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
                    threshold.value = with(layoutCoordinates) {
                        positionInParent().y + boundsInParent().height / 4
                    }
                },
            )

            PokemonData(
                height,
                weight,
                baseExperience,
                captureRate,
            )

            HorizontalDivider(color = Gray200)

            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                PokemonVarieties(
                    varieties = varieties.toImmutableList(),
                    onVarietyClick = {
                        onPokemonClick(it.id)
                    },
                )

                if (evolutionChain != null) {
                    PokemonEvolution(evolutionChain)
                }

                PokemonStats(stats)

                Spacer(Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun PokemonProfile(
    showdownUrl: String,
    idLabel: String,
    name: String,
    nameJa: String,
    genus: String,
    types: ImmutableList<PokemonType>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Gray100)
                .border(1.dp, Gray500, RoundedCornerShape(24.dp)),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Gray50),
            ) {
                AsyncImage(
                    showdownUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1F)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Gray200.copy(alpha = 0.8F))
                    .padding(top = 4.dp, bottom = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    idLabel,
                    modifier = Modifier
                        .background(Gray300, CircleShape)
                        .padding(horizontal = 4.dp, vertical = 2.dp),
                    color = Gray600,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Column(
            modifier = Modifier.weight(1F),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Column {
                Text(
                    name,
                    color = Gray900,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayMedium,
                )

                Text(
                    nameJa,
                    color = Gray900,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                )
            }

            Text(
                genus,
                color = Gray500,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelLarge,
            )

            Spacer(Modifier)

            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                types.forEach { type ->
                    PokemonTypeTag(type)
                }
            }
        }
    }
}

internal val Pokemon.idLabel: String
    get() = when (id) {
        in 1..9 -> "#000$id"
        in 10..99 -> "#00$id"
        in 100..999 -> "#0$id"
        else -> "#$id"
    }

@Composable
private fun PokemonData(
    height: Meter,
    weight: Kilogram,
    baseExperience: Int,
    captureRate: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(White)
            .horizontalScroll(rememberScrollState()),
    ) {
        Spacer(Modifier.width(16.dp))

        listOf(
            stringResource(Res.string.height) to height,
            stringResource(Res.string.weight) to weight,
            stringResource(Res.string.base_experience) to baseExperience,
        ).forEach { (name, value) ->
            PokemonDataEntry(name, value.toString())

            VerticalDivider(
                modifier = Modifier.padding(vertical = 16.dp),
                color = Gray100
            )
        }

        PokemonDataEntry(
            name = stringResource(Res.string.catch_rate),
            value = captureRate.toString(),
        )

        Spacer(Modifier.width(16.dp))
    }
}

@Composable
private fun PokemonDataEntry(
    name: String,
    value: String,
) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Max),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalDivider(color = Gray100)

        Column(
            modifier = Modifier.padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = name,
                color = Gray600,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = value,
                color = Gray600,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall,
            )
        }

        Spacer(Modifier)
    }
}