package lopez.ibarra.myapplication.view.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lopez.ibarra.myapplication.model.data.pkmnList
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexListContent()
        }
    }
}

@Composable
fun PokedexListContent() {
    ComposePokedexTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MenuPokedex(pokemonList = pkmnList, innerPadding = innerPadding)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexListPreview() {
    PokedexListContent()
}
