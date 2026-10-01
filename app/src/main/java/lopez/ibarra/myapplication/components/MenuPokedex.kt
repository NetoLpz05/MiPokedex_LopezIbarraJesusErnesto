package lopez.ibarra.myapplication.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.data.pkmnList
import lopez.ibarra.myapplication.domain.Pokemon
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme

@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues) {
    LazyColumn(contentPadding = innerPadding) {
        items(pokemonList) { pokemon ->
            PokemonRow(pokemon)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexPreview() {
    ComposePokedexTheme {
        MenuPokedex(pokemonList = pkmnList, innerPadding = PaddingValues(0.dp))
    }
}
