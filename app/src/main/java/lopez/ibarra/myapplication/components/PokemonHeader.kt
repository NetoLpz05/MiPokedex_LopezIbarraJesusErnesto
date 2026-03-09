package lopez.ibarra.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.composePokedex.R
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.utilities.Pokemon
import lopez.ibarra.myapplication.utilities.getColorByType

@Composable
fun PokemonHeader(pokemon: Pokemon, pkmnNum:Int, fav: Boolean){
    val colors = getColorByType(pokemon)
    Row(Modifier.fillMaxWidth().padding(15.dp).background(colors.first), horizontalArrangement = Arrangement.SpaceBetween){
        Column{
            Text(pokemon.name)
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

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview(){
    ComposePokedexTheme {

        val pokemon = Pokemon(
            "Ogerpon",
            1017,
            "Planta",
            "Es bromista y extremadamente curioso.",
            1.2f,
            39.8f,
            true,
            "Competitivo",
            R.drawable.ogerpon2
        )

        PokemonHeader(pokemon, pokemon.number, pokemon.fav)
    }
}