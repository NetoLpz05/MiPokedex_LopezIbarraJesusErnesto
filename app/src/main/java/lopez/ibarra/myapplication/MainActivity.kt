package lopez.ibarra.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lopez.ibarra.myapplication.components.Ability
import lopez.ibarra.myapplication.components.Chip
import lopez.ibarra.myapplication.components.OtherPkmn
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.ui.theme.White
import lopez.ibarra.myapplication.ui.theme.leaf_green
import lopez.ibarra.myapplication.utilities.Pokemon

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon("Ogerpon", 1017, "Planta",
        "Es bromista y extremadamente curioso. A la hora de combatir, se sirve del tipo de " +
                "energía que contenga la máscara que lleve puesta.", 39.8f, 1.2f,
        true, "Competitivo", R.drawable.ogerpon2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        pokemon,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonHeader(pkmnName:String, pkmnNum:Int, fav: Boolean){
    Row(Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Column(){
            Text(pkmnName)
            Text("#${pkmnNum}", modifier = Modifier.align(Alignment.End))
        }
        Box{
            Image(painter = painterResource(R.drawable.pokeball), contentDescription = "pokeball image",
                contentScale = ContentScale.Fit, modifier = Modifier.size(150.dp)
                    .offset(30.dp, 20.dp))
            Image(
                painter = painterResource(
                    if (fav) R.drawable.star_filled else R.drawable.star_outline
                ),
                contentDescription = if (fav) "yellow star filled" else "yellow star outlined",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
fun PokemonCard(name: String, height: Float, weight: Float, description: String,
                ability:String, type: String, image: Int){
    Box(contentAlignment = Alignment.TopCenter){
        Image(painter = painterResource(image), contentDescription = name, Modifier.offset
            (0.dp, -80.dp)
            .zIndex(2f).size(150.dp), contentScale = ContentScale.Fit)
        Card(Modifier.fillMaxWidth().fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(White))
        {
            Column(Modifier.fillMaxWidth()) {
                Chip(type, leaf_green, Modifier.padding(top = 70.dp).
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
                Row(Modifier.fillMaxWidth(.8f).align(Alignment.CenterHorizontally)
                    .padding(25.dp)) {
                    Text(description)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview(){
    ComposePokedexTheme() {
        PokemonHeader("Ogerpon", 1017,true)
    }
}

@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(leaf_green)
    ) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)

        Box(modifier = Modifier.weight(1f)) {
            PokemonCard(
                pokemon.name, pokemon.height, pokemon.weight,
                pokemon.description, pokemon.ability, pokemon.type, pokemon.image
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().background(White).padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                OtherPkmn(posicion = "izquierda", imagen = R.drawable.fezandipiti, pkmnnombre = "Fezandipiti", pkmnnumber = 1016)
            }
            Box(modifier = Modifier.weight(1f)) {
                OtherPkmn(posicion = "derecha", imagen = R.drawable.archaludon, pkmnnombre = "Archadulor", pkmnnumber = 1018)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePokedexTheme {
        Greeting(Pokemon("Ogerpon", 1017, "Planta", "Es bromista y " +
                "extremadamente curioso. A la hora de combatir, se sirve del tipo de " +
                "energía que contenga la máscara que lleve puesta.",
            39.8f, 1.2f, true, "Competitivo", R.drawable.ogerpon2))
    }
}