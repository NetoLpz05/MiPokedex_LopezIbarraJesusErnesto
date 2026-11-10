package lopez.ibarra.myapplication.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lopez.ibarra.myapplication.model.domain.Pokemon
import lopez.ibarra.myapplication.model.preferences.ARCHIVO
import lopez.ibarra.myapplication.model.preferences.PokemonSerializer

val Context.dataStore: DataStore<Pokemon> by dataStore(
    fileName = "pokemon.json",
    serializer = PokemonSerializer, scope = CoroutineScope(Dispatchers.IO)
)

class CompanionPreferences(private val context: Context) {
    private val shared = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE)

    suspend fun saveCompanion(compa: Pokemon) {
        context.dataStore.updateData { compa }
        shared.edit().putLong("companion_date", System.currentTimeMillis()).apply()
    }

    fun pkmnCompanion(): Flow<Pokemon> =
        context.dataStore.data.map { pokemon -> pokemon }

    fun getCompanionDays(): Int {
        val dateSaved = shared.getLong("companion_date", 0L)
        if (dateSaved == 0L) return 0
        val diffMillis = System.currentTimeMillis() - dateSaved
        val days = (diffMillis / (1000 * 60 * 60 * 24)).toInt()
        return if (days < 0) 0 else days
    }
}
