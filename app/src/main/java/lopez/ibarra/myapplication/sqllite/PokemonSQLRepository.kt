package lopez.ibarra.myapplication.sqllite

import lopez.ibarra.myapplication.model.data.interfaces.IPokemonDAO
import lopez.ibarra.myapplication.model.data.interfaces.IPokemonRepository
import lopez.ibarra.myapplication.model.domain.Pokemon

class PokemonSQLRepository(private val dao: IPokemonDAO) : IPokemonRepository {
    override suspend fun addPokemon(pokemon: Pokemon) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun getPokemons(): List<Pokemon> {
        return dao.getAllPokemons()
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        return dao.getFavoritePokemons()
    }

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return dao.getPokemonsByType(type)
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        dao.updatePokemon(pokemon)
    }

    override suspend fun deletePokemon(id: Int) {
        val pkmn = dao.getPokemonById(id)
        if (pkmn != null) {
            dao.deletePokemon(pkmn)
        }
    }
}
