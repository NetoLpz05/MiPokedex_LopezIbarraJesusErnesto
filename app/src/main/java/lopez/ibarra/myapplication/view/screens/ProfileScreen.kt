package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import lopez.ibarra.myapplication.ui.theme.Pink40
import lopez.ibarra.myapplication.ui.theme.Typography
import lopez.ibarra.myapplication.viewmodel.UserViewModel

@Composable
fun ProfileScreen(innerPadding: PaddingValues) {
                  //userVM: UserViewModel = viewModel())
    val nombre = "Ernesto"
        //if(userVM.currentUser != null) userVM.currentUser!!.name else "Nombre usuario"
    val correo = "ernesto@mail.com"
        //if(userVM.currentUser != null) userVM.currentUser!!.email else "usuario@mail.com"
    Column(Modifier.fillMaxSize().padding(innerPadding).padding(15.dp)) {
        Text(nombre
            , style = Typography.titleLarge, color = Pink40)

        Text(correo,
            style = Typography.titleLarge, color = Pink40)

        Text("Mi compañero", style = Typography.bodyLarge)

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen(PaddingValues(20.dp))
}