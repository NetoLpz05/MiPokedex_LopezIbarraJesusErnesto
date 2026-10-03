package lopez.ibarra.myapplication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.ui.theme.OffWhite
import lopez.ibarra.myapplication.utilities.getColorByType

@Composable
fun PokemonRow(pokemon: Pokemon) {
    val colors = getColorByType(pokemon.type)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )
        Column(
            modifier = Modifier
                .weight(0.7f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = pokemon.description,
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Height: ${pokemon.height}",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "Weight: ${pokemon.weight}",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        NumberChip(
            text = pokemon.number.toString(),
            modifier = Modifier.align(Alignment.Top),
            colors = colors
        )
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon) {
    val colors = getColorByType(pokemon.type)
    Column(
        modifier = Modifier.padding(vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Box(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
                    .border(
                        BorderStroke(
                            5.dp,
                            Brush.sweepGradient(
                                listOf(
                                    colors.first,
                                    OffWhite,
                                    colors.first,
                                    OffWhite,
                                    colors.first
                                )
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    modifier = Modifier
                        .padding(5.dp)
                        .width(75.dp)
                )
            }
            NumberChip(
                text = pokemon.number.toString(),
                colors = colors
            )
        }
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun PokemonCell(pokemon: Pokemon) {
    val colors = getColorByType(pokemon.type)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(5.dp)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
            )
            NumberChip(
                text = pokemon.number.toString(),
                colors = colors
            )
        }
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonElementPreview() {
    ComposePokedexTheme {
        Column {
            FavoritePokemon(
                pokemon = Pokemon(
                    "Bulbasaur", 1, "Grass", "Bulbasaur description",
                    0.7f, 6.9f, true, "Overgrow", R.drawable.ogerpon, listOf(1, 2, 3)
                )
            )
            PokemonCell(
                pokemon = Pokemon(
                    "Bulbasaur", 1, "Grass", "Bulbasaur description",
                    0.7f, 6.9f, true, "Overgrow", R.drawable.ogerpon, listOf(1, 2, 3)
                )
            )
        }
    }
}
