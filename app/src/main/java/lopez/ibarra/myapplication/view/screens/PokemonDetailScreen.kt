package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import lopez.ibarra.myapplication.model.domain.Pokemon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lopez.ibarra.myapplication.view.components.*
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.utilities.getColorByType
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.itemsIndexed
import lopez.ibarra.myapplication.model.data.*
import lopez.ibarra.myapplication.view.components.PokemonHeader

@Composable
fun PokemonCard(name: String, height: Float, weight: Float, description: String,
                ability:String, type: String, image: Int, typeColor: Color, evolutions: List<Pokemon>){
    Box(contentAlignment = Alignment.TopCenter){
        Image(painter = painterResource(image), contentDescription = name, Modifier.offset
            (0.dp, -80.dp)
            .zIndex(2f).size(150.dp), contentScale = ContentScale.Fit)
        Card(Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface))
        {
            Column(Modifier.fillMaxWidth()) {
                Chip(type, typeColor, Modifier.padding(top = 70.dp).
                align(Alignment.CenterHorizontally))
                Row(modifier = Modifier.fillMaxWidth(.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 18.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(end = 24.dp)) {
                        Ability("row", label = "Altura ", "${height} m")
                        Ability("row", label = "Peso ", "${weight} kg")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Ability("column", "Habilidad", value = ability)
                    }
                }
                Row(Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally).padding(25.dp)) {
                    Text(text = description, color = MaterialTheme.colorScheme.onSurface)
                }
                Text(
                    text = "Evolución", 
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp)
                )

                if (evolutions.size <= 1) {
                    Text(text = "Este Pokémon no tiene evolución o es un Pokémon legendario / singular",
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally))
                } else {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth().padding(16.dp), 
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        itemsIndexed(evolutions) { index, evo ->
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 8.dp)) {
                                Image(
                                    painter = painterResource(evo.image),
                                    contentDescription = evo.name,
                                    modifier = Modifier.size(70.dp)
                                )
                                Text(text = evo.name, color = MaterialTheme.colorScheme.onSurface)
                            }
                            if (index < evolutions.size - 1) {
                                Text(
                                    text = "→",
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(horizontal = 6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun PokemonDetailScreen(innerPadding: PaddingValues, pokemonId: Int, onNavigateDetail: (Int) -> Unit) {
    val pokemon = getPokemon(pokemonId)
    val colors = getColorByType(pokemon.type)
    val allPokemon = showAllPokemon()
    val evolutions = allPokemon.filter {
        pokemon.evolutions.contains(it.number)
    }

    val index = allPokemon.indexOfFirst { it.number == pokemon.number }
    val prev = if (index > 0) allPokemon[index - 1] else null
    val next = if (index < allPokemon.size - 1) allPokemon[index + 1] else null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.first)
    ) {
        // Aplicar el padding superior solo al header
        Box(modifier = Modifier.padding(top = innerPadding.calculateTopPadding())) {
            PokemonHeader(pokemon, pokemon.number, pokemon.fav)
        }

        Box(modifier = Modifier.weight(1f)) {
            PokemonCard(
                pokemon.name, pokemon.height, pokemon.weight,
                pokemon.description, pokemon.ability, pokemon.type, pokemon.image, colors.first,
                evolutions = evolutions)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(bottom = innerPadding.calculateBottomPadding())
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            prev?.let { p ->
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OtherPkmn(
                        posicion = "izquierda",
                        imagen = p.image,
                        pkmnnombre = p.name,
                        pkmnnumber = p.number,
                        onArrowClick = { onNavigateDetail(p.number) }
                    )
                }
            }

            next?.let { n ->
                Row(modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
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

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    ComposePokedexTheme {
        PokemonDetailScreen(innerPadding = PaddingValues(0.dp), pokemonId = 1017, onNavigateDetail = {})
    }
}
