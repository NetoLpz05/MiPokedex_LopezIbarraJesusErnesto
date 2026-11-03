package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.model.data.Users
import lopez.ibarra.myapplication.ui.theme.ComposePokedexTheme
import lopez.ibarra.myapplication.viewmodel.UserViewModel

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    onNavigateToMenu: () -> Unit,
    viewModel: UserViewModel
) {
    var user by remember { mutableStateOf("") }
    val passwordState = remember { TextFieldState("") }

    if (viewModel.isLoggedIn()) {
        LaunchedEffect(Unit) {
            onNavigateToMenu()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Correo electrónico") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 8.dp)
            )

            SecureTextField(
                state = passwordState,
                label = { Text("Contraseña") },
                textObfuscationMode = TextObfuscationMode.RevealLastTyped,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.login(user, passwordState.text.toString())
                    if (!viewModel.loginError) {
                        onNavigateToMenu()
                    }
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("Iniciar sesión")
            }

            if (viewModel.loginError) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = viewModel.errorDescription,
                    color = Color.Red,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposePokedexTheme {
        val context = LocalContext.current
        val userViewModel = remember {
            UserViewModel(Users(context)).apply {
                logout()
            }
        }
        LoginScreen(
            innerPadding = PaddingValues(0.dp),
            onNavigateToMenu = {},
            viewModel = userViewModel
        )
    }
}
