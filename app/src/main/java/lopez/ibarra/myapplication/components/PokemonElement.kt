package lopez.ibarra.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.ui.theme.Green

@Composable
fun PokemonRow(pokemon: Pokemon) {
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
        Text(
            text = pokemon.number.toString(),
            modifier = Modifier
                .align(Alignment.Top)
                .background(Green)
                .padding(horizontal = 5.dp, vertical = 2.dp),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowPreview() {
    ComposePokedexTheme {
        PokemonRow(
            pokemon = Pokemon(
                "Ogerpon",
                1017,
                "Planta",
                "Es bromista y extremadamente curioso. A la hora de combatir, " +
                        "se sirve del tipo de energía que contenga la máscara que lleve puesta.",
                1.2f,
                39.8f,
                true,
                "Competitivo",
                R.drawable.ogerpon,
                evolutions = listOf(1017)
            )
        )
    }
}


