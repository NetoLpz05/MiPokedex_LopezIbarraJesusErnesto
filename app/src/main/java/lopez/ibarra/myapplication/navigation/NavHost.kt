package lopez.ibarra.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import lopez.ibarra.myapplication.view.screens.MenuPokedexScreen
import lopez.ibarra.myapplication.view.screens.PokemonDetailScreen
import lopez.ibarra.myapplication.model.data.toggleFavorite

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
                },
                onNavigateToMega = { id ->
                    navController.navigate(route = PokemonMegaDetail(id))
                },
                onToggleFavorite = { id -> toggleFavorite(id) }
            )
        }

        composable<PokemonMegaDetail>{ backStackEntry ->
            val detail: PokemonMegaDetail = backStackEntry.toRoute()
            // Podemos reusar la misma pantalla de detalle pero indicando que es modo Mega
            PokemonDetailScreen(
                innerPadding = innerPadding,
                pokemonId = detail.pokemon,
                onNavigateDetail = { id -> 
                    navController.navigate(route = PokemonDetail(id)) {
                        popUpTo(PokemonList) { inclusive = false }
                    }
                },
                onNavigateToMega = {}, // En la pantalla de mega no mostramos otro botón de mega
                onToggleFavorite = { id -> toggleFavorite(id) }
            )
        }
    }
}
