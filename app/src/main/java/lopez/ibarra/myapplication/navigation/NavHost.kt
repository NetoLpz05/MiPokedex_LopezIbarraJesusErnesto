package lopez.ibarra.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import lopez.ibarra.myapplication.view.screens.MenuPokedexScreen
import lopez.ibarra.myapplication.view.screens.PokemonDetailScreen
import lopez.ibarra.myapplication.model.data.toggleFavorite
import lopez.ibarra.myapplication.view.screens.PokemonHuntScreen

@Composable
fun MyApp(innerPadding: PaddingValues){
    val navController = rememberNavController()
    NavHost(navController, startDestination= PokemonList){
        composable<PokemonList>{
            MenuPokedexScreen(innerPadding,
                onNavigateToDetail = {id-> navController.navigate(route = PokemonDetail(id)) },
                onNavigateToHunt = {navController.navigate(route = PokemonHunt)})
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
                },
                onNavigateToMega = { id ->
                    navController.navigate(route = PokemonMegaDetail(id))
                },
                onToggleFavorite = { id -> toggleFavorite(id) }
            )
        }

        composable<PokemonMegaDetail>{ backStackEntry ->
            val detail: PokemonMegaDetail = backStackEntry.toRoute()
            PokemonDetailScreen(
                innerPadding = innerPadding,
                pokemonId = detail.pokemon,
                onNavigateDetail = { id -> 
                    navController.navigate(route = PokemonDetail(id)) {
                        popUpTo(PokemonList) { inclusive = false }
                    }
                },
                onNavigateToMega = {},
                onToggleFavorite = { id -> toggleFavorite(id) }
            )
        }

        composable<PokemonHunt>{
            PokemonHuntScreen(innerPadding)
        }
    }
}
