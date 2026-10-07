package lopez.ibarra.myapplication.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.model.data.pkmnList
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme

@Composable
fun FavoritesRow(favoriteList: List<Pokemon>, onNavigateToDetail:(id: Int) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        items(favoriteList) { pokemon ->
            FavoritePokemon(pokemon, onNavigateToDetail)
        }
    }
}

@Composable
fun PokedexGrid(pokemonList: List<Pokemon>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        items(pokemonList) { pokemon ->
            PokemonCell(pokemon)
        }
    }
}

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues = PaddingValues(0.dp)) {
    PokedexGrid(pokemonList = pokemonList, modifier = Modifier.padding(innerPadding))
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    ComposePokedexTheme {
        MenuPokedex(pokemonList = pkmnList)
    }
}
