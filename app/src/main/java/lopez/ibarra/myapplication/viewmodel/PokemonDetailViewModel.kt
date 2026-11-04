package lopez.ibarra.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lopez.ibarra.myapplication.model.data.CompanionPreferences
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonDetailViewModel(private val companionDS: CompanionPreferences) : ViewModel() {
    fun saveCompanion(pokemon: Pokemon){
        viewModelScope.launch {
            companionDS.saveCompanion(pokemon)
        }
    }
}