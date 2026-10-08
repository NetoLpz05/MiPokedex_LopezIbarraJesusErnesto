package lopez.ibarra.myapplication.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.utilities.getColorByType

@Composable
fun PokemonHeader(pokemon: Pokemon, pkmnNum: Int, isFavorite: Boolean, onToggleFavorite: () -> Unit) {
    val colors = getColorByType(pokemon.type)
    Row(
        Modifier
            .fillMaxWidth()
            .background(colors.first)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.headlineMedium,
                color = colors.second
            )
            Text(
                text = "#${String.format("%03d", pkmnNum)}",
                style = MaterialTheme.typography.titleMedium,
                color = colors.second
            )
        }
        Box(contentAlignment = Alignment.CenterEnd) {
            Image(
                painter = painterResource(R.drawable.pokeball),
                contentDescription = "pokeball image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(120.dp)
                    .offset(x = 20.dp, y = 10.dp)
                    .alpha(0.3f)
            )
            Image(
                painter = painterResource(
                    if (isFavorite) R.drawable.star_filled else R.drawable.star_outline
                ),
                contentDescription = if (isFavorite) "favorite" else "not favorite",
                modifier = Modifier
                    .size(36.dp)
                    .clickable { onToggleFavorite() }
            )
        }
    }
}
