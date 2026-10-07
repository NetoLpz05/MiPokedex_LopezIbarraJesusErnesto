package lopez.ibarra.myapplication.model.data

import lopez.ibarra.myapplication.model.domain.Pokemon

data class PokedexState(val team: List<Pokemon> = emptyList(), val lastCaptured: Pokemon? = null)
