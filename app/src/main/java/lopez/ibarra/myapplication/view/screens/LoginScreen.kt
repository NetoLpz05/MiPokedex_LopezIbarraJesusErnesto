package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import lopez.ibarra.myapplication.viewmodel.UserViewModel

@Composable
fun LoginScreen(innerPadding: PaddingValues, onNavigateToMenu: ()-> Unit, viewModel: UserViewModel = viewModel()) {
    var user by remember { mutableStateOf("") }
    var password = remember { TextFieldState("")}

    if(viewModel.isLoggedIn()){
        onNavigateToMenu()
    } else {
        Column(Modifier.fillMaxWidth().fillMaxHeight().padding(innerPadding)) {

            TextField(value = user, onValueChange = {it -> user = it},
                label = {
                    Text("Correo Electrónico")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))


            SecureTextField(state = password,
                label = {
                    Text("Contraseña")
                }, textObfuscationMode = TextObfuscationMode.RevealLastTyped,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

            Button(onClick = {viewModel.login(user, password.text as String)
                if (!viewModel.loginError){
                    onNavigateToMenu()
                }
            })  {
                Text("Iniciar Sesión")
            }

            Spacer(Modifier.size(40.dp))

            if(viewModel.loginError){
                Text(
                    viewModel.errorDescription, color = Color.Red,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}