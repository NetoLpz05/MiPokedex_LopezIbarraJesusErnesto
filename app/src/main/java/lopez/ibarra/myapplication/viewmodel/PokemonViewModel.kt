package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import lopez.ibarra.myapplication.model.domain.Pokemon
import androidx.compose.runtime.*
import lopez.ibarra.myapplication.model.data.pkmnList

class PokemonViewModel : ViewModel(){
    var wildPkmn by mutableStateOf<Pokemon?>(null)
        private set

    var capturedPkmn by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePkmn by mutableStateOf(false)

    var isPokemonCaptured by mutableStateOf(false)

    fun searchPkmn(){
        wildPkmn = pkmnList.random()
    }

    fun capturePokemon(){
        wildPkmn?.let {
            var isCaptured = (1..2).random()
            if (isCaptured == 1){
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