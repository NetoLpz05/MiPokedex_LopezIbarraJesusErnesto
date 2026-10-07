package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import lopez.ibarra.myapplication.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(innerPadding: PaddingValues, viewModel: PokemonViewModel = viewModel()){
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button({}) {
            //Buscar pokemon en la hierva
            Text("hola mucho gusto, bienvenido a la casa de los sustos")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PkmnHuntPreview(){
    PokemonHuntScreen(PaddingValues(15.dp))
}