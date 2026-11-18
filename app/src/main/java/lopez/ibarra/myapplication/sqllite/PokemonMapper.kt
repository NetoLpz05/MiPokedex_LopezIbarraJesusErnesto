package lopez.ibarra.myapplication.sqllite

import android.content.ContentValues
import android.database.Cursor
import androidx.core.database.getFloatOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonMapper {
    fun getPokemon(cursor: Cursor): Pokemon {
        val num = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_NUMBER))
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_NAME))
        val type = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_TYPE))
        val description = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_DESCRIPTION))
        val height = cursor.getFloatOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_HEIGHT))
        val weight = cursor.getFloatOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_WEIGHT))
        val fav = cursor.getIntOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_FAVORITE))
        val image = cursor.getBlob(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_IMAGE))
        val ability = cursor.getStringOrNull(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_ABILITY))

        return Pokemon(
            name = name,
            number = num,
            type = type,
            description = description,
            height = height?: 0f,
            weight = weight?: 0f,
            fav = if (fav == null || fav == 0) false else true,
            ability = ability?: "",
            image = R.drawable.wtp,
            sqlImage = image,
            evolutions = emptyList(),
            megaEvoIds = emptyList()
        )
    }

    fun getContentValues(pokemon: Pokemon): ContentValues {
        val values = ContentValues().apply {
            put(Contract.Pokemones.COLUMN_NAME_NUMBER, pokemon.number)
            put(Contract.Pokemones.COLUMN_NAME_NAME, pokemon.name)
            put(Contract.Pokemones.COLUMN_NAME_DESCRIPTION, pokemon.description)
            put(Contract.Pokemones.COLUMN_NAME_TYPE, pokemon.type)

            put(Contract.Pokemones.COLUMN_NAME_ABILITY, pokemon.ability)
            put(Contract.Pokemones.COLUMN_NAME_WEIGHT, pokemon.weight)
            put(Contract.Pokemones.COLUMN_NAME_HEIGHT, pokemon.height)
            put(Contract.Pokemones.COLUMN_NAME_IMAGE, pokemon.image)
            put(Contract.Pokemones.COLUMN_NAME_FAVORITE, pokemon.fav)

        }
        return values
    }
}
