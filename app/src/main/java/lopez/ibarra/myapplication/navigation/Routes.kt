package lopez.ibarra.myapplication.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
data class PokemonDetail(val pokemon: Int)

@Serializable
data class PokemonMegaDetail(val pokemon: Int)
