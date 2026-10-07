package lopez.ibarra.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import lopez.ibarra.myapplication.data.getPokemon
import lopez.ibarra.myapplication.screens.MenuPokedexScreen
import lopez.ibarra.myapplication.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()
    NavHost(navController, startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding,
                onNavigateToDetail = {id-> navController.navigate(route = PokemonDetail(id)) })
        }

        composable<PokemonDetail>{
            val pokemon = it.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(innerPadding, getPokemon(pokemon))
        }
    }
}