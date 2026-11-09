package lopez.ibarra.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import lopez.ibarra.myapplication.model.data.CompanionPreferences
import lopez.ibarra.myapplication.model.data.toggleFavorite
import lopez.ibarra.myapplication.view.screens.LoginScreen
import lopez.ibarra.myapplication.view.screens.MenuPokedexScreen
import lopez.ibarra.myapplication.view.screens.PokemonDetailRoute
import lopez.ibarra.myapplication.view.screens.PokemonDetailScreen
import lopez.ibarra.myapplication.view.screens.PokemonHuntScreen
import lopez.ibarra.myapplication.view.screens.ProfileScreen
import lopez.ibarra.myapplication.viewmodel.PokemonDetailViewModel
import lopez.ibarra.myapplication.viewmodel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues, userViewModel: UserViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current

    val pokemonDVM = viewModel<PokemonDetailViewModel> {
        PokemonDetailViewModel(CompanionPreferences(context))
    }

    val navigateToDetail = { id: Int -> navController.navigate(route = PokemonDetail(id)) }
    val navigateToMenu = {
        navController.navigate(PokemonList) {
            popUpTo(Login) { inclusive = true }
        }
    }

    NavHost(navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                innerPadding = innerPadding,
                onNavigateToMenu = navigateToMenu,
                viewModel = userViewModel
            )
        }

        composable<PokemonList> {
            MenuPokedexScreen(
                innerPadding = innerPadding,
                onNavigateToDetail = { id -> navController.navigate(route = PokemonDetail(id)) },
                onNavigateToHunt = { navController.navigate(route = PokemonHunt) },
                onNavigateToProfile = { navController.navigate(route = Profile) }, // <- Pasar la navegación al perfil
                onLogout = {
                    userViewModel.logout()
                    navController.navigate(Login) {
                        popUpTo(PokemonList) { inclusive = true }
                    }
                },
                viewModel = userViewModel
            )
        }

        composable<PokemonDetail> { backStackEntry ->
            val detail: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailRoute(
                innerPadding = innerPadding,
                pokemonId = detail.pokemon,
                pokemonDVM = pokemonDVM,
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

        composable<PokemonMegaDetail> { backStackEntry ->
            val detail: PokemonMegaDetail = backStackEntry.toRoute()
            PokemonDetailRoute(
                innerPadding = innerPadding,
                pokemonId = detail.pokemon,
                pokemonDVM = pokemonDVM,
                onNavigateDetail = { id ->
                    navController.navigate(route = PokemonDetail(id)) {
                        popUpTo(PokemonList) { inclusive = false }
                    }
                },
                onNavigateToMega = {},
                onToggleFavorite = { id -> toggleFavorite(id) }
            )
        }

        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding, onNavigateToDetail = navigateToDetail)
        }

        composable<Profile> {
            ProfileScreen(innerPadding, userViewModel)
        }
    }
}