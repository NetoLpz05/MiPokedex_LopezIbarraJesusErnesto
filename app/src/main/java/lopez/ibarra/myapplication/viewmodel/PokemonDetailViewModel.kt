package lopez.ibarra.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import lopez.ibarra.myapplication.model.data.CompanionPreferences
import lopez.ibarra.myapplication.model.data.getPokemon
import lopez.ibarra.myapplication.model.data.showAllPokemon
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonDetailViewModel(private val companionDS: CompanionPreferences) : ViewModel() {

    val companion: Flow<Pokemon> = companionDS.pkmnCompanion()

    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent: SharedFlow<String> = _toastEvent.asSharedFlow()

    fun getPokemonById(id: Int): Pokemon = getPokemon(id)

    fun getEvolutions(pokemon: Pokemon): List<Pokemon> {
        val allPokemon = showAllPokemon()
        return allPokemon.filter { pokemon.evolutions.contains(it.number) }
    }

    fun getPreviousPokemon(pokemon: Pokemon): Pokemon? {
        val allPokemon = showAllPokemon()
        val index = allPokemon.indexOfFirst { it.number == pokemon.number }
        return if (index > 0) allPokemon[index - 1] else null
    }

    fun getNextPokemon(pokemon: Pokemon): Pokemon? {
        val allPokemon = showAllPokemon()
        val index = allPokemon.indexOfFirst { it.number == pokemon.number }
        return if (index >= 0 && index < allPokemon.size - 1) allPokemon[index + 1] else null
    }

    fun saveCompanion(pokemon: Pokemon) {
        viewModelScope.launch {
            companionDS.saveCompanion(pokemon)
            _toastEvent.emit("Compañero seleccionado")
        }
    }

    fun toggleFavorite(id: Int) {
        lopez.ibarra.myapplication.model.data.toggleFavorite(id)
    }
}
