package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.ui.theme.Pink40
import lopez.ibarra.myapplication.ui.theme.Typography
import lopez.ibarra.myapplication.viewmodel.UserViewModel
import androidx.compose.runtime.collectAsState


@Composable
fun ProfileScreen(innerPadding: PaddingValues, userVM: UserViewModel = viewModel()) {
    val nombre = if(userVM.currentUser != null) userVM.currentUser!!.name else "Nombre usuario"
    val correo = if(userVM.currentUser != null) userVM.currentUser!!.email else "usuario@mail.com"
    //val image = R.drawable.litten
    val image = if(userVM.currentUser != null) userVM.companion.collectAsState().value.image else -1
    val pokemonName = if(userVM.currentUser != null) userVM.companion.collectAsState().value.name else "No selected"
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = nombre,
            style = Typography.titleLarge, color = Pink40)

        Text(text = correo,
            style = Typography.titleLarge,
            color = Pink40)

        Text(text = "Mi compañero",
            style = Typography.bodyLarge)

        Image(painter = painterResource(id = image),
            contentDescription = pokemonName)

        Text(pokemonName, style = Typography.labelMedium,
            fontStyle = FontStyle.Italic)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(PaddingValues(20.dp))
}