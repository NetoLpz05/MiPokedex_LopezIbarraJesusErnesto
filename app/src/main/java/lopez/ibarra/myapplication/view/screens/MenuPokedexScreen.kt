package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.view.components.FavoritesRow
import lopez.ibarra.myapplication.view.components.PokemonCell
import lopez.ibarra.myapplication.view.components.PokemonRow
import lopez.ibarra.myapplication.model.data.pkmnList
import lopez.ibarra.myapplication.ui.theme.*

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (id: Int) -> Unit) {
    val favorites = pkmnList.filter { it.fav }
    var grid by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (grid) "Vista Cuadrícula" else "Vista Lista",
                style = MaterialTheme.typography.titleMedium
            )
            Switch(
                checked = grid,
                onCheckedChange = { grid = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green,
                    checkedTrackColor = LightGreen,
                    uncheckedThumbColor = Blue,
                    uncheckedTrackColor = LightBlue,
                    uncheckedBorderColor = Color.Transparent
                ),
                thumbContent = if (grid) {
                    {
                        Icon(
                            painter = painterResource(R.drawable.grid),
                            contentDescription = "grid icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                } else {
                    {
                        Icon(
                            painter = painterResource(R.drawable.list),
                            contentDescription = "list icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                }
            )
        }

        if (grid) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.fillMaxSize()
            ) {
                if (favorites.isNotEmpty()) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Text(
                                text = "Mis Favoritos",
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                            FavoritesRow(favoriteList = favorites, onNavigateToDetail)
                        }
                    }
                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = "Mis pokemones",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                items(pkmnList) { pokemon ->
                    PokemonCell(pokemon = pokemon, onNavigateToDetail = onNavigateToDetail)
                }
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                if (favorites.isNotEmpty()) {
                    item {
                        Column {
                            Text(
                                text = "Mis Favoritos",
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                            FavoritesRow(favoriteList = favorites, onNavigateToDetail)
                        }
                    }
                }

                item {
                    Text(
                        text = "Mis pokemones",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                items(pkmnList) { pokemon ->
                    PokemonRow(pokemon = pokemon, onNavigateToDetail = onNavigateToDetail)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    ComposePokedexTheme {
        MenuPokedexScreen(
            innerPadding = PaddingValues(0.dp),
            onNavigateToDetail = {}
        )
    }
}
