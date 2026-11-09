package lopez.ibarra.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import lopez.ibarra.myapplication.model.data.CompanionPreferences
import lopez.ibarra.myapplication.model.data.Users
import lopez.ibarra.myapplication.navigation.MyApp
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = Users(this)
        val companionDS = CompanionPreferences(this)
        val userViewModel = UserViewModel(users = users, companionDS = companionDS)

        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MyApp(innerPadding, userViewModel)
                    }
                }
            }
        }
    }
}