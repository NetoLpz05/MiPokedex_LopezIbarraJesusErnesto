package lopez.ibarra.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lopez.ibarra.myapplication.navigation.MyApp
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(innerPadding)
                }
            }
        }
    }
}

@Preview(showBackground = true,)
@Composable
fun MainActivityPreview() {
    ComposePokedexTheme {
        Scaffold(Modifier.fillMaxSize()) { innerPadding ->
            MyApp(innerPadding)
        }
    }
}