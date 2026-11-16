package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.data.CompanionPreferences
import lopez.ibarra.myapplication.model.data.Users
import lopez.ibarra.myapplication.model.data.pkmnList
import lopez.ibarra.myapplication.ui.theme.Blue
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.ui.theme.Green
import lopez.ibarra.myapplication.ui.theme.LightBlue
import lopez.ibarra.myapplication.ui.theme.LightGreen
import lopez.ibarra.myapplication.view.components.FavoritesRow
import lopez.ibarra.myapplication.view.components.PokemonCell
import lopez.ibarra.myapplication.view.components.PokemonRow
import lopez.ibarra.myapplication.viewmodel.UserViewModel

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues,
    onNavigateToDetail: (id: Int) -> Unit,
    onNavigateToHunt: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToAddPokemon: () -> Unit,
    onLogout: () -> Unit,
    viewModel: UserViewModel
) {
    val favorites = pkmnList.filter { it.fav }
    var grid by remember { mutableStateOf(viewModel.getGridPreference()) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier
                                .size(50.dp)
                                .clickable { onNavigateToProfile() }
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Perfil",
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }

                        OutlinedButton(
                            onClick = onLogout,
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            Text("Log out")
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Switch(
                            checked = grid,
                            onCheckedChange = {
                                grid = it
                                viewModel.saveGridPreference(it)
                            },
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

                        Text(
                            text = if (grid) "Vista Cuadrícula" else "Vista Lista",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 6.dp)
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onNavigateToAddPokemon,
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "+",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    Button(
                        onClick = onNavigateToHunt,
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Catch New",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
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
                                    text = "Favorite Pokemons",
                                    style = MaterialTheme.typography.headlineSmall,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                )
                                FavoritesRow(favoriteList = favorites, onNavigateToDetail = onNavigateToDetail)
                            }
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Text(
                            text = "All pokemons",
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
                                    text = "Favorite Pokemons",
                                    style = MaterialTheme.typography.headlineSmall,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                )
                                FavoritesRow(favoriteList = favorites, onNavigateToDetail = onNavigateToDetail)
                            }
                        }
                    }

                    item {
                        Text(
                            text = "All pokemons",
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
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    ComposePokedexTheme {
        val context = LocalContext.current
        val userViewModel = remember {
            UserViewModel(
                users = Users(context),
                companionDS = CompanionPreferences(context)
            )
        }
        MenuPokedexScreen(
            innerPadding = PaddingValues(0.dp),
            onNavigateToDetail = {},
            onNavigateToHunt = {},
            onNavigateToProfile = {},
            onNavigateToAddPokemon = {},
            onLogout = {},
            viewModel = userViewModel
        )
    }
}
