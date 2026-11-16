package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.data.interfaces.IPokemonRepository
import lopez.ibarra.myapplication.model.domain.Pokemon

class AddPokemonViewModel(private val pokemonRepository: IPokemonRepository) : ViewModel() {

    private val pokemonsMutable = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = pokemonsMutable.asStateFlow()

    var pokemonSaved by mutableStateOf(false)
        private set

    init {
        loadPokemons()
    }

    fun loadPokemons() {
        viewModelScope.launch {
            pokemonsMutable.value = pokemonRepository.getPokemons()
        }
    }

    fun savePokemon(name: String, type: String, number: Int, description: String) {
        val savingPokemon = Pokemon(
            name = name,
            number = number,
            type = type,
            description = description,
            height = 0f,
            weight = 0f,
            fav = false,
            ability = "",
            image = R.drawable.pokeball,
            evolutions = emptyList(),
            megaEvoIds = emptyList()
        )

        viewModelScope.launch {
            pokemonRepository.addPokemon(savingPokemon)
            pokemonSaved = true
            loadPokemons()
        }
    }
}
