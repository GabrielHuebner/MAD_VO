package com.example.mad_vo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mad_vo.screens.DetailScreen
import com.example.mad_vo.screens.FavoritesScreen
import com.example.mad_vo.screens.HomeScreen
import com.example.mad_vo.viewmodels.FavoriteViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyNavigation(){
    val navController = rememberNavController()
    val favoriteViewModel: FavoriteViewModel = viewModel()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){ HomeScreen(navController, viewModel = favoriteViewModel) }
        composable(
            route = MovieScreens.DetailScreen.name + "/{movieId}",
            arguments = listOf(
                navArgument(name = "movieId"){
                    type = NavType.StringType
                }
            )
        ){  backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            DetailScreen(movieId = movieId, navController = navController, viewModel = favoriteViewModel)
        }
        composable(MovieScreens.FavoritesScreen.name){ FavoritesScreen(navController, viewModel = favoriteViewModel)}
    }
}
