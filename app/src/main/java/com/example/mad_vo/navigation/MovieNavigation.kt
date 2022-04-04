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

@Composable
fun MyNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){ HomeScreen(navController) }
        composable(
            route = MovieScreens.DetailScreen.name + "/{movieId}",
            arguments = listOf(
                navArgument(name = "movieId"){
                    type = NavType.StringType
                }
            )
        ){  backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            DetailScreen(movieId = movieId, navController = navController)
        }
        composable(MovieScreens.FavoritesScreen.name){ FavoritesScreen(navController)}
    }
}
