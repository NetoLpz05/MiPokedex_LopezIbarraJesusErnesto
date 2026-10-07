package lopez.ibarra.myapplication.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.*
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
fun FavoritePokemon(pokemon: Pokemon, onNavigateToDetail: (id:Int)->Unit){
    val colors = getColorByType(pokemon.type)
    Column(Modifier.width(150.dp).padding(vertical = 15.dp)
        .clickable(true, onClick = {onNavigateToDetail(pokemon.number as Int)})
        , verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Box() {
            Box(
                Modifier.border(
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
                    painterResource(pokemon.image),
                    contentDescription = "${pokemon.name} image",
                    Modifier.width(75.dp).align(Alignment.Center)
                        .padding(5.dp)
                )

            }
            NumberChip("${pokemon.number}", Modifier.align(Alignment.BottomEnd).offset(15.dp, 15.dp), colors)
        }
        Text(pokemon.name, style = Typography.labelLarge)
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
            PokemonRow(
                pokemon = Pokemon(
                    "Ogerpon", 1, "Grass", "Ogerpon description",
                    0.7f, 6.9f, true, "Overgrow", R.drawable.ogerpon, listOf(1, 2, 3)
                )
            )
            FavoritePokemon(
                pokemon = Pokemon(
                    "Ogerpon", 1, "Grass", "Ogerpon description",
                    0.7f, 6.9f, true, "Overgrow", R.drawable.ogerpon, listOf(1, 2, 3)
                ),
                onNavigateToDetail = {}
            )
            PokemonCell(
                pokemon = Pokemon(
                    "Ogerpon", 1, "Grass", "Ogerpon description",
                    0.7f, 6.9f, true, "Overgrow", R.drawable.ogerpon, listOf(1, 2, 3)
                )
            )
        }
    }
}