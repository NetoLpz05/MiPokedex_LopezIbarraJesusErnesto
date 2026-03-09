package lopez.ibarra.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import lopez.ibarra.myapplication.dummies.getPokemon
import lopez.ibarra.myapplication.dummies.showAllPokemon
import lopez.ibarra.myapplication.screens.LoginScreen
import lopez.ibarra.myapplication.screens.PokedexMenuScreen
import lopez.ibarra.myapplication.screens.PokemonDetailScreen
import lopez.ibarra.myapplication.screens.RegisterScreen

@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(navController, Login) {

        composable<Login> {
            LoginScreen(
                onLogin = {
                    navController.navigate(PokemonList)
                },
                onRegister = {
                    navController.navigate(Register)
                }
            )
        }

        composable<Register> {
            RegisterScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<PokemonList> {
            PokedexMenuScreen(
                showAllPokemon(),
                onNavigationDetail = { id ->
                    navController.navigate(PokemonDetail(id = id))
                }
            )
        }

        composable<PokemonDetail> { backStackEntry ->

            val route: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemon(route.id)

            val pokemonList = showAllPokemon()
            val index = pokemonList.indexOfFirst { it.number == pokemon.number }

            val prev = pokemonList.getOrNull(index - 1)
            val next = pokemonList.getOrNull(index + 1)

            PokemonDetailScreen(pokemon = pokemon, prevNext = Pair(prev, next),
                onNavigateDetail = { id ->
                    navController.navigate(PokemonDetail(id = id))
                }
            )
        }
    }
}