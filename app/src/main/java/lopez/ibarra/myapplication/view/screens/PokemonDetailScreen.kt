package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import lopez.ibarra.myapplication.model.domain.Pokemon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lopez.ibarra.myapplication.view.components.*
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.utilities.getColorByType
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.data.*
import lopez.ibarra.myapplication.view.components.PokemonHeader

@Composable
fun PokemonCard(
    pokemon: Pokemon, 
    typeColor: Color, 
    evolutions: List<Pokemon>,
    onNavigateToMega: (Int) -> Unit
) {
    Box(contentAlignment = Alignment.TopCenter) {
        // Imagen principal del Pokemon
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
                // Botones de Megaevolución (si existen)
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
                            .padding(vertical = 20.dp)
                    )

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
fun PokemonDetailScreen(
    innerPadding: PaddingValues, 
    pokemonId: Int, 
    onNavigateDetail: (Int) -> Unit,
    onNavigateToMega: (Int) -> Unit,
    onToggleFavorite: (Int) -> Unit
) {
    val pokemon = getPokemon(pokemonId)
    val colors = getColorByType(pokemon.type)
    val allPokemon = showAllPokemon()
    
    // Mostramos la familia completa (incluyendo al actual)
    val evolutions = allPokemon.filter { pokemon.evolutions.contains(it.number) }

    val index = allPokemon.indexOfFirst { it.number == pokemon.number }
    val prev = if (index > 0) allPokemon[index - 1] else null
    val next = if (index < allPokemon.size - 1) allPokemon[index + 1] else null

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
                onNavigateToMega = onNavigateToMega
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
                    prev?.let { p ->
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
                    next?.let { n ->
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
