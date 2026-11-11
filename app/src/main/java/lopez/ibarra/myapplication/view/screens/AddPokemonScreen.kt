package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lopez.ibarra.myapplication.ui.theme.Typography
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import lopez.ibarra.myapplication.model.domain.pokemonTypes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPokemonScreen(innerPadding: PaddingValues){
    var number = remember { TextFieldState() }
    var name = remember { TextFieldState() }
    var type = remember { TextFieldState() }
    val height = remember { TextFieldState() }
    val weight = remember { TextFieldState() }
    var ability = remember { TextFieldState() }
    var description = remember { TextFieldState() }
    var openType by remember {mutableStateOf(false)}

    Column(Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Agregar Pokémon",
            Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge)

        Spacer(Modifier.size(20.dp))

        TextField(
            state = number,
            label = {
                Text("Número de Pokédex")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            state = name,
            label = {
                Text("Nombre del Pokémon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        ExposedDropdownMenuBox(
            openType,
            { openType = it }
        ) {
            OutlinedTextField(
                readOnly = true,
                label = {Text("Selecciona el tipo del Pokémon")},
                state = type,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = openType)
                },
                modifier = Modifier.menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryNotEditable)
            )

            ExposedDropdownMenu(expanded = openType,
                onDismissRequest = { openType = false }) {
                pokemonTypes.forEach { selectedType ->
                    DropdownMenuItem(
                        text = { Text(selectedType) },
                        onClick = {
                            type.setTextAndPlaceCursorAtEnd(selectedType)
                            openType = false
                        }
                    )
                }
            }
        }

        TextField(
            state = height,
            label = { Text("Altura (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        TextField(
            state = weight,
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        TextField(
            state = ability,
            label = {
                Text("Habilidad del Pokémon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            state = description,
            label = {
                Text("Descripción del Pokémon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddPokemonScreenPreview(){
    AddPokemonScreen(PaddingValues(20.dp))
}