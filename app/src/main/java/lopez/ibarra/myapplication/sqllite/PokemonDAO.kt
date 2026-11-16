package lopez.ibarra.myapplication.sqllite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lopez.ibarra.myapplication.model.data.interfaces.IPokemonDAO
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonDAO(private val helper: DatabaseHelper) : IPokemonDAO {
    val mapper = PokemonMapper()

    override suspend fun insertPokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = helper.writableDatabase
            db.insert(
                Contract.Pokemones.TABLE_NAME,
                null,
                mapper.getContentValues(pokemon)
            )
            db.close()
        }
    }

    override suspend fun getAllPokemons(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = helper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemones.TABLE_NAME}"
            val cursor = db.rawQuery(query, null)
            cursor.use { c ->
                buildList {
                    while (c.moveToNext()) {
                        add(mapper.getPokemon(c))
                    }
                }
            }
        }
    }

    override suspend fun getPokemonById(id: Int): Pokemon? {
        return withContext(Dispatchers.IO) {
            val db = helper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemones.TABLE_NAME} WHERE ${Contract.Pokemones.COLUMN_NAME_NUMBER} = ?"
            val cursor = db.rawQuery(query, arrayOf(id.toString()))
            cursor.use { c ->
                if (c.moveToFirst()) {
                    mapper.getPokemon(c)
                } else null
            }
        }
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        return emptyList()
    }

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = helper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemones.TABLE_NAME} WHERE ${Contract.Pokemones.COLUMN_NAME_TYPE} = ?"
            val cursor = db.rawQuery(query, arrayOf(type))
            cursor.use { c ->
                buildList {
                    while (c.moveToNext()) {
                        add(mapper.getPokemon(c))
                    }
                }
            }
        }
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = helper.writableDatabase
            db.update(
                Contract.Pokemones.TABLE_NAME,
                mapper.getContentValues(pokemon),
                "${Contract.Pokemones.COLUMN_NAME_NUMBER} = ?",
                arrayOf(pokemon.number.toString())
            )
            db.close()
        }
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = helper.writableDatabase
            db.delete(
                Contract.Pokemones.TABLE_NAME,
                "${Contract.Pokemones.COLUMN_NAME_NUMBER} = ?",
                arrayOf(pokemon.number.toString())
            )
            db.close()
        }
    }
}
