package lopez.ibarra.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import lopez.ibarra.myapplication.model.domain.Pokemon
import androidx.compose.runtime.*

class PokemonViewModel : ViewModel(){
    var wildPkmn by mutableStateOf<Pokemon?>(null)
    fun capturePokemon(){

    }
}