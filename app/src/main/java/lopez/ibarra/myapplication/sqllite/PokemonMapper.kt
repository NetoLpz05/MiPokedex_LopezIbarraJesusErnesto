package lopez.ibarra.myapplication.sqllite

import android.content.ContentValues
import android.database.Cursor
import lopez.ibarra.myapplication.R
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonMapper {
    fun getPokemon(cursor: Cursor): Pokemon {
        val num = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_NUMBER))
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_NAME))
        val type = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_TYPE))
        val description = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemones.COLUMN_NAME_DESCRIPTION))

        return Pokemon(
            name = name,
            number = num,
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
    }

    fun getContentValues(pokemon: Pokemon): ContentValues {
        val values = ContentValues().apply {
            put(Contract.Pokemones.COLUMN_NAME_NUMBER, pokemon.number)
            put(Contract.Pokemones.COLUMN_NAME_NAME, pokemon.name)
            put(Contract.Pokemones.COLUMN_NAME_DESCRIPTION, pokemon.description)
            put(Contract.Pokemones.COLUMN_NAME_TYPE, pokemon.type)
        }
        return values
    }
}
