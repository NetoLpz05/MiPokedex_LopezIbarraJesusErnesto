package lopez.ibarra.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lopez.ibarra.composePokedex.R
import lopez.ibarra.myapplication.components.Ability
import lopez.ibarra.myapplication.components.Chip
import lopez.ibarra.myapplication.components.OtherPkmn
import lopez.ibarra.myapplication.navigation.MyApp
import lopez.ibarra.myapplication.screens.PokemonDetailScreen
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.ui.theme.White
import lopez.ibarra.myapplication.ui.theme.leaf_green
import lopez.ibarra.myapplication.utilities.Pokemon

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon("Ogerpon", 1017, "Planta",
        "Es bromista y extremadamente curioso. A la hora de combatir, se sirve del tipo de " +
                "energía que contenga la máscara que lleve puesta.", 39.8f, 1.2f,
        true, "Competitivo", R.drawable.ogerpon2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                MyApp()
            }
        }
    }
}