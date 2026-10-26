package lopez.ibarra.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lopez.ibarra.myapplication.model.data.Users
import lopez.ibarra.myapplication.model.preferences.ARCHIVO
import lopez.ibarra.myapplication.navigation.MyApp
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.view.screens.LoginScreen
import lopez.ibarra.myapplication.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = Users(this)
        val userViewModel = UserViewModel(users)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MyApp(innerPadding, userViewModel)
                        //LoginScreen(innerPadding, {})
                    }
                }
            }
            val sharedP = getSharedPreferences(ARCHIVO, MODE_PRIVATE)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ComposePokedexTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                MyApp(
                    innerPadding,
                    userViewModel = TODO(),
                )
            }
        }
    }
}
