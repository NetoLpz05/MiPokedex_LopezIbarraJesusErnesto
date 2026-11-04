package lopez.ibarra.myapplication.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.model.preferences.PokemonSerializer
import lopez.ibarra.myapplication.viewmodel.PokemonViewModel

val Context.dataStore: DataStore<Pokemon> by dataStore(
    fileName = "pokemon.json",
    serializer = PokemonSerializer, scope = CoroutineScope(Dispatchers.IO)
)

class CompanionPreferences (private val context: Context){
    suspend fun saveCompanion(compa: Pokemon){
        context.dataStore.updateData {
            pokemon -> compa
        }
    }
    
    fun pkmnCompanion(): Flow<Pokemon> =
        context.dataStore.data.map{
            pokemon -> pokemon
    }
}