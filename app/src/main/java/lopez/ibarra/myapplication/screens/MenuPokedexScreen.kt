package lopez.ibarra.myapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.components.FavoritesRow
import lopez.ibarra.myapplication.components.PokemonCell
import lopez.ibarra.myapplication.data.pkmnList

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (id: Int) -> Unit) {
    val favorites = pkmnList.filter { it.fav }

    LazyVerticalGrid(columns = GridCells.Fixed(3),
        Modifier.fillMaxSize().padding(innerPadding)) {
        if (favorites.isNotEmpty()) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column {
                    Text(text = "Mis Favoritos",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                    FavoritesRow(favoriteList = favorites, onNavigateToDetail)
                }
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(text = "Mis pokemones",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        items(pkmnList) { pokemon ->
            PokemonCell(pokemon = pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    MaterialTheme {
        MenuPokedexScreen(
            innerPadding = PaddingValues(0.dp)
                , {})
    }
}