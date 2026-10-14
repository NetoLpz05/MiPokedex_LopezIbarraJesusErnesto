package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import lopez.ibarra.myapplication.ui.theme.*
import lopez.ibarra.myapplication.view.components.PokemonRow
import lopez.ibarra.myapplication.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(
    innerPadding: PaddingValues,
    viewModel: PokemonViewModel = viewModel(),
    onNavigateToDetail: (id: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para buscar Pokémon
        Button(onClick = { viewModel.searchPkmn() }) {
            Text("Buscar Pokémon")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Si hay un Pokémon salvaje en pantalla
        viewModel.wildPkmn?.let { pokemon ->
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "¡Apareció un ${pokemon.name} salvaje!",
                style = Typography.labelLarge,
                color = Purple80
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Botón de captura
            Button(onClick = { viewModel.capturePokemon() }) {
                Text("Capturar a ${pokemon.name}")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Mensajes de estado
            if (viewModel.gonePkmn) {
                Text(
                    text = "El Pokémon se ha escapado :(",
                    style = Typography.labelLarge,
                    color = Color.Magenta
                )
            }

            if (viewModel.isPokemonCaptured) {
                Text(
                    text = "¡Has capturado al Pokémon! :)",
                    style = Typography.labelLarge,
                    color = Green
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Título de la lista
        Text(
            text = "Pokémon capturados",
            style = Typography.titleLarge,
            color = Purple40
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Lista de Pokémon capturados
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(viewModel.capturedPkmn) { pokemon ->
                PokemonRow(
                    pokemon = pokemon,
                    onNavigateToDetail = onNavigateToDetail
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PkmnHuntPreview() {
    PokemonHuntScreen(PaddingValues(0.dp), onNavigateToDetail = {})
}