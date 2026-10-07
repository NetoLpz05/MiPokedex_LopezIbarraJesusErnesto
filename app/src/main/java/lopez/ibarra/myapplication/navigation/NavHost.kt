package lopez.ibarra.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import lopez.ibarra.myapplication.view.screens.MenuPokedexScreen
import lopez.ibarra.myapplication.view.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()
    NavHost(navController, startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding,
                onNavigateToDetail = {id-> navController.navigate(route = PokemonDetail(id)) })
        }

        composable<PokemonDetail>{ backStackEntry ->
            val detail: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(
                innerPadding = innerPadding,
                pokemonId = detail.pokemon,
                onNavigateDetail = { id -> 
                    navController.navigate(route = PokemonDetail(id)) {
                        popUpTo(PokemonList) { inclusive = false }
                    }
                }
            )
        }
    }
}
