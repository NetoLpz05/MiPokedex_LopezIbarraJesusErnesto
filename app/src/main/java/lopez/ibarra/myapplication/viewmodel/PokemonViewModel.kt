package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import lopez.ibarra.myapplication.model.data.pkmnList
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var wildPkmn by mutableStateOf<Pokemon?>(null)
        private set

    var capturedPkmn by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePkmn by mutableStateOf(false)

    var isPokemonCaptured by mutableStateOf(false)

    fun searchPkmn() {
        wildPkmn = pkmnList.random()
        gonePkmn = false
        isPokemonCaptured = false
    }

    fun capturePokemon() {
        wildPkmn?.let {
            val isCaptured = (1..2).random()
            if (isCaptured == 1) {
                capturedPkmn = capturedPkmn + it
                gonePkmn = false
                wildPkmn = null
                isPokemonCaptured = true
            } else {
                gonePkmn = true
                wildPkmn = null
                isPokemonCaptured = false
            }
        }
    }
}
