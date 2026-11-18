package lopez.ibarra.myapplication.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import lopez.ibarra.myapplication.model.domain.pokemonTypes
import lopez.ibarra.myapplication.sqllite.DatabaseHelper
import lopez.ibarra.myapplication.sqllite.PokemonDAO
import lopez.ibarra.myapplication.sqllite.PokemonSQLRepository
import lopez.ibarra.myapplication.ui.theme.Typography
import lopez.ibarra.myapplication.viewmodel.AddPokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPokemonScreen(
    innerPadding: PaddingValues,
    addPokemonViewModel: AddPokemonViewModel
) {
    val number = remember { TextFieldState() }
    val name = remember { TextFieldState() }
    val type1 = remember { TextFieldState() }
    val type2 = remember { TextFieldState() }
    val height = remember { TextFieldState() }
    val weight = remember { TextFieldState() }
    var favorite by remember { mutableStateOf(false) }
    val ability = remember { TextFieldState() }
    val description = remember { TextFieldState() }
    var openType1 by remember { mutableStateOf(false) }
    var openType2 by remember { mutableStateOf(false) }

    val pokemonList by addPokemonViewModel.pokemons.collectAsStateWithLifecycle()

    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Agregar Pokémon",
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )

        TextField(
            state = number,
            label = { Text("Número de Pokédex") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            state = name,
            label = { Text("Nombre del Pokémon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        ExposedDropdownMenuBox(
            expanded = openType1,
            onExpandedChange = { openType1 = it }
        ) {
            OutlinedTextField(
                readOnly = true,
                label = { Text("Tipo Primario") },
                state = type1,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = openType1)
                },
                modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
            )

            ExposedDropdownMenu(
                expanded = openType1,
                onDismissRequest = { openType1 = false }
            ) {
                pokemonTypes.forEach { selectedType ->
                    DropdownMenuItem(
                        text = { Text(selectedType) },
                        onClick = {
                            type1.setTextAndPlaceCursorAtEnd(selectedType)
                            openType1 = false
                        }
                    )
                }
            }
        }

        ExposedDropdownMenuBox(
            expanded = openType2,
            onExpandedChange = { openType2 = it }
        ) {
            OutlinedTextField(
                readOnly = true,
                label = { Text("Tipo Secundario (Opcional)") },
                state = type2,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = openType2)
                },
                modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
            )

            ExposedDropdownMenu(
                expanded = openType2,
                onDismissRequest = { openType2 = false }
            ) {
                (listOf("Ninguno") + pokemonTypes).forEach { selectedType ->
                    DropdownMenuItem(
                        text = { Text(selectedType) },
                        onClick = {
                            type2.setTextAndPlaceCursorAtEnd(if (selectedType == "Ninguno") "" else selectedType)
                            openType2 = false
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
            label = { Text("Habilidad del Pokémon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        TextField(
            state = description,
            label = { Text("Descripción del Pokémon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Row{
            Text("¿Marcar como favorito?")
            Switch(
                checked = favorite,
                onCheckedChange = { favorite = it }
            )
        }

        Button(
            onClick = {
                val t1 = type1.text.toString().trim()
                val t2 = type2.text.toString().trim()
                val finalType = if (t2.isNotEmpty() && t2 != "Ninguno") "$t1 / $t2" else t1

                addPokemonViewModel.savePokemon(
                    name = name.text.toString(),
                    type = finalType,
                    number = number.text.toString().toIntOrNull() ?: 0,
                    description = description.text.toString()
                )
            }
        ) {
            Text("Guardar Pokémon")
        }

        Spacer(Modifier.height(10.dp))

        Text(
            text = "Pokémones Guardados:",
            style = Typography.titleMedium
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(pokemonList) { pokemon ->
                Text(
                    text = pokemon.toString(),
                    style = Typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPokemonScreenPreview() {
    val context = LocalContext.current
    val helper = DatabaseHelper(context)
    val dao = PokemonDAO(helper)
    val repo = PokemonSQLRepository(dao)
    val vm = remember { AddPokemonViewModel(repo) }

    AddPokemonScreen(
        innerPadding = PaddingValues(20.dp),
        addPokemonViewModel = vm
    )
}
