package lopez.ibarra.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lopez.ibarra.myapplication.components.Ability
import lopez.ibarra.myapplication.components.Chip
import lopez.ibarra.myapplication.components.OtherPkmn
import lopez.ibarra.myapplication.components.PokemonHeader
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.ui.theme.White
import lopez.ibarra.myapplication.utilities.Pokemon
import lopez.ibarra.myapplication.utilities.getColorByType
import androidx.compose.ui.graphics.Color
import lopez.ibarra.myapplication.dummies.showAllPokemon
import androidx.compose.foundation.lazy.itemsIndexed

@Composable
fun PokemonCard(name: String, height: Float, weight: Float, description: String,
                ability:String, type: String, image: Int, typeColor: Color, evolutions: List<Pokemon>){
    Box(contentAlignment = Alignment.TopCenter){
        Image(painter = painterResource(image), contentDescription = name, Modifier.offset
            (0.dp, -80.dp)
            .zIndex(2f).size(150.dp), contentScale = ContentScale.Fit)
        Card(Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(White))
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
                    Text(description)
                }
                Text(text = "Evolución", modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))

                if (evolutions.size <= 1) {
                    Text(text = "Este Pokémon no tiene evolución o no hay datos registrados de las evoluciones",
                        modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally))
                } else {
                    LazyColumn(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        itemsIndexed(evolutions) { index, evo ->
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 8.dp)) {
                                Image(
                                    painter = painterResource(evo.image),
                                    contentDescription = evo.name,
                                    modifier = Modifier.size(70.dp)
                                )
                                Text(evo.name)
                            }
                            if (index < evolutions.size - 1) {
                                Text(
                                    text = "↓",
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
fun PokemonDetailScreen(pokemon: Pokemon, prevNext: Pair<Pokemon?, Pokemon?>, onNavigateDetail: (Int) -> Unit, modifier: Modifier = Modifier) {
    val colors = getColorByType(pokemon)
    val evolutions = showAllPokemon().filter {
        pokemon.evolutions.contains(it.number)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.first)
    ) {
        PokemonHeader(pokemon, pokemon.number, pokemon.fav)

        Box(modifier = Modifier.weight(1f)) {
            PokemonCard(
                pokemon.name, pokemon.height, pokemon.weight,
                pokemon.description, pokemon.ability, pokemon.type, pokemon.image, colors.first,
                evolutions = evolutions)
        }

        Row(
            modifier = Modifier.fillMaxWidth().background(White).padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            prevNext.first?.let { prev ->

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OtherPkmn(
                        posicion = "izquierda",
                        imagen = prev.image,
                        pkmnnombre = prev.name,
                        pkmnnumber = prev.number,
                        onArrowClick = { onNavigateDetail(prev.number) }
                    )
                }
            }

            prevNext.second?.let { next ->
                Row(modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {

                    OtherPkmn(
                        posicion = "derecha",
                        imagen = next.image,
                        pkmnnombre = next.name,
                        pkmnnumber = next.number,
                        onArrowClick = { onNavigateDetail(next.number) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {

    val pokemonList = showAllPokemon()
    val pokemon = pokemonList[0]

    val index = pokemonList.indexOfFirst { it.number == pokemon.number }

    val prev = pokemonList.getOrNull(index - 1)
    val next = pokemonList.getOrNull(index + 1)

    ComposePokedexTheme {
        PokemonDetailScreen(pokemon = pokemon, prevNext = Pair(prev, next),
            onNavigateDetail = {}
        )
    }
}