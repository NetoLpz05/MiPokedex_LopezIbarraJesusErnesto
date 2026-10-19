package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import lopez.ibarra.myapplication.viewmodel.UserViewModel

@Composable
fun LoginScreen(innerPadding: PaddingValues, onNavigateToMenu: ()-> Unit, viewModel: UserViewModel = viewModel(),
                setSuccesfullLogin: (username: String, mail: String) -> Unit){
    var user by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}

    Column() {

        TextField(value = user, onValueChange = {it -> user = it},
            label = {
                Text("Correo Electrónico")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))


        TextField(value = password, onValueChange = {it -> password = it},
            label = {
                Text("Contraseña")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Button(onClick = {}) {
            Text("Iniciar Sesión")
        }
    }
}