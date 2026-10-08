package lopez.ibarra.myapplication.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.utilities.getColorByType

@Composable
fun PokemonHeader(pokemon: Pokemon, pkmnNum:Int, fav: Boolean){
    val colors = getColorByType(pokemon.type)
    Row(
        Modifier.fillMaxWidth().padding(15.dp).background(colors.first), 
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text = pokemon.name, 
                style = MaterialTheme.typography.headlineMedium,
                color = colors.second
            )
            Text(
                text = "#${pkmnNum}", 
                style = MaterialTheme.typography.titleMedium,
                color = colors.second
            )
        }
        Box {
            Image(
                painter = painterResource(R.drawable.pokeball), 
                contentDescription = "pokeball image",
                contentScale = ContentScale.Fit, 
                modifier = Modifier.size(120.dp).offset(20.dp, 10.dp).alpha(0.3f)
            )
            Image(
                painter = painterResource(
                    if (fav) R.drawable.star_filled else R.drawable.star_outline
                ),
                contentDescription = if (fav) "yellow star filled" else "yellow star outlined",
                modifier = Modifier.size(32.dp).align(Alignment.TopEnd)
            )
        }
    }
}
