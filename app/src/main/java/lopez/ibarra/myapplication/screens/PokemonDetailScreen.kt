package lopez.ibarra.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import lopez.ibarra.myapplication.domain.Pokemon

@Composable
fun PokemonDetailScreen(innerPaddingValues: PaddingValues, pokemon: Pokemon){
    Column() {
        Text(pokemon.name)
        Image(painterResource(pokemon.image), contentDescription = "${pokemon.name} image")
    }
}