package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.data.getPokemon
import lopez.ibarra.myapplication.model.data.showAllPokemon
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.utilities.getColorByType
import lopez.ibarra.myapplication.view.components.Ability
import lopez.ibarra.myapplication.view.components.Chip
import lopez.ibarra.myapplication.view.components.OtherPkmn
import lopez.ibarra.myapplication.view.components.PokemonHeader
import lopez.ibarra.myapplication.viewmodel.PokemonDetailViewModel
import androidx.compose.runtime.getValue

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    typeColor: Color,
    evolutions: List<Pokemon>,
    isCompanion: Boolean,
    onNavigateToMega: (Int) -> Unit,
    onSelectCompanion: () -> Unit
) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier
                .offset(y = (-80).dp)
                .zIndex(2f)
                .size(160.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                if (pokemon.megaEvoIds.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        pokemon.megaEvoIds.forEachIndexed { index, megaId ->
                            Image(
                                painter = painterResource(if (index == 1) R.drawable.evoz else R.drawable.megaevo),
                                contentDescription = "Mega Evolución",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .clickable { onNavigateToMega(megaId) }
                            )
                        }
                    }
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Chip(
                        text = pokemon.type,
                        color = typeColor,
                        modifier = Modifier
                            .padding(top = 80.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 18.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.Start) {
                            Ability("row", label = "Altura ", "${pokemon.height} m")
                            Ability("row", label = "Peso ", "${pokemon.weight} kg")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Ability("column", "Habilidad", value = pokemon.ability)
                        }
                    }

                    Text(
                        text = pokemon.description,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 16.dp)
                    )

                    if (isCompanion) {
                        Surface(
                            color = typeColor.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 12.dp)
                        ) {
                            Text(
                                text = "★ Es tu compañero",
                                color = typeColor,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                            )
                        }
                    } else {
                        Button(
                            onClick = onSelectCompanion,
                            colors = ButtonDefaults.buttonColors(containerColor = typeColor),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 12.dp)
                        ) {
                            Text(text = "Elegir como compañero")
                        }
                    }

                    Text(
                        text = "Evolución",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    if (evolutions.isEmpty()) {
                        Text(
                            text = "Este Pokémon no tiene evoluciones adicionales",
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                            modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally)
                        )
                    } else {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            itemsIndexed(evolutions) { index, evo ->
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(horizontal = 8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(evo.image),
                                        contentDescription = evo.name,
                                        modifier = Modifier.size(70.dp)
                                    )
                                    Text(
                                        text = evo.name,
                                        color = if (evo.number == pokemon.number) typeColor else MaterialTheme.colorScheme.onSurface,
                                        style = if (evo.number == pokemon.number) MaterialTheme.typography.labelLarge else MaterialTheme.typography.bodyMedium
                                    )
                                }
                                if (index < evolutions.size - 1) {
                                    Text(
                                        text = "→",
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.padding(horizontal = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonDetailRoute(
    innerPadding: PaddingValues,
    pokemonId: Int,
    pokemonDVM: PokemonDetailViewModel,
    onNavigateDetail: (Int) -> Unit,
    onNavigateToMega: (Int) -> Unit,
    onToggleFavorite: (Int) -> Unit
) {
    val pokemon = pokemonDVM.getPokemonById(pokemonId)
    val evolutions = pokemonDVM.getEvolutions(pokemon)
    val prev = pokemonDVM.getPreviousPokemon(pokemon)
    val next = pokemonDVM.getNextPokemon(pokemon)

    val currentCompanion by pokemonDVM.companion.collectAsStateWithLifecycle(initialValue = null)
    val isCompanion = currentCompanion != null && currentCompanion?.name == pokemon.name

    PokemonDetailScreen(
        innerPadding = innerPadding,
        pokemon = pokemon,
        evolutions = evolutions,
        prevPokemon = prev,
        nextPokemon = next,
        isCompanion = isCompanion,
        onNavigateDetail = onNavigateDetail,
        onNavigateToMega = onNavigateToMega,
        onSelectCompanion = { pokemonDVM.saveCompanion(it) },
        onToggleFavorite = onToggleFavorite
    )
}

@Composable
fun PokemonDetailScreen(
    innerPadding: PaddingValues,
    pokemon: Pokemon,
    evolutions: List<Pokemon>,
    prevPokemon: Pokemon?,
    nextPokemon: Pokemon?,
    isCompanion: Boolean,
    onNavigateDetail: (Int) -> Unit,
    onNavigateToMega: (Int) -> Unit,
    onSelectCompanion: (Pokemon) -> Unit,
    onToggleFavorite: (Int) -> Unit
) {
    val colors = getColorByType(pokemon.type)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.first)
    ) {
        Box(modifier = Modifier.padding(top = innerPadding.calculateTopPadding())) {
            PokemonHeader(
                pokemon = pokemon,
                pkmnNum = pokemon.number,
                isFavorite = pokemon.fav,
                onToggleFavorite = { onToggleFavorite(pokemon.number) }
            )
        }

        Box(modifier = Modifier.weight(1f).padding(top = 40.dp)) {
            PokemonCard(
                pokemon = pokemon,
                typeColor = colors.first,
                evolutions = evolutions,
                isCompanion = isCompanion,
                onNavigateToMega = onNavigateToMega,
                onSelectCompanion = { onSelectCompanion(pokemon) }
            )
        }

        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = innerPadding.calculateBottomPadding())
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    prevPokemon?.let { p ->
                        OtherPkmn(
                            posicion = "izquierda",
                            imagen = p.image,
                            pkmnnombre = p.name,
                            pkmnnumber = p.number,
                            onArrowClick = { onNavigateDetail(p.number) }
                        )
                    }
                }

                Box(modifier = Modifier.weight(1f)) {
                    nextPokemon?.let { n ->
                        OtherPkmn(
                            posicion = "derecha",
                            imagen = n.image,
                            pkmnnombre = n.name,
                            pkmnnumber = n.number,
                            onArrowClick = { onNavigateDetail(n.number) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailScreenPreview() {
    val samplePokemon = getPokemon(25)

    ComposePokedexTheme {
        PokemonDetailScreen(
            innerPadding = PaddingValues(0.dp),
            pokemon = samplePokemon,
            evolutions = emptyList(),
            prevPokemon = null,
            nextPokemon = null,
            isCompanion = true,
            onNavigateDetail = {},
            onNavigateToMega = {},
            onSelectCompanion = {},
            onToggleFavorite = {}
        )
    }
}