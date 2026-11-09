package lopez.ibarra.myapplication.model.preferences

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.domain.Pokemon
import java.io.InputStream
import java.io.OutputStream

object PokemonSerializer : Serializer<Pokemon> {
    override val defaultValue: Pokemon = Pokemon(
        name = "",
        number = -1,
        type = "",
        description = "",
        height = 0f,
        weight = 0f,
        fav = false,
        ability = "",
        image = R.drawable.wtp,
        evolutions = emptyList(),
        megaEvoIds = emptyList()
    )

    override suspend fun readFrom(input: InputStream): Pokemon {
        return try {
            Json.decodeFromString(
                Pokemon.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            throw CorruptionException("No se pudo leer el JSON", e)
        }
    }

    override suspend fun writeTo(t: Pokemon, output: OutputStream) {
        output.write(Json.encodeToString(
                Pokemon.serializer(), t).toByteArray()
        )
    }
}