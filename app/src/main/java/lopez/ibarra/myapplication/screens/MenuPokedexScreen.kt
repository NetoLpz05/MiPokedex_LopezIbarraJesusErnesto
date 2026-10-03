package lopez.ibarra.myapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.components.FavoritesRow
import lopez.ibarra.myapplication.components.PokedexGrid
import lopez.ibarra.myapplication.data.pkmnList

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues) {
    val favorites = pkmnList.filter { it.fav }
    
    Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
        Text(
            text = "Mis Favoritos",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        FavoritesRow(favoriteList = favorites)
        
        Text(
            text = "Todos mis pokemones",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        PokedexGrid(pokemonList = pkmnList)
    }
}
