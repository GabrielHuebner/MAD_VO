package com.example.mad_vo.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mad_vo.models.getMovies
import com.example.mad_vo.navigation.MovieScreens
import com.example.mad_vo.widgets.MovieRow
import com.example.mad_vo.viewmodels.FavoriteViewModel

@Composable
fun FavoritesScreen(navController: NavController = rememberNavController(), viewModel: FavoriteViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Blue, elevation = 3.dp){
                Row{
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.width(20.dp))

                    Text("Favorites")
                }
            }
        }
    ) {
        MainContentFavorites(viewModel, navController)
    }
}

@Composable
fun MainContentFavorites(viewModel: FavoriteViewModel, navController: NavController){
    LazyColumn {
        items(viewModel.getAllFavorites()) { movie ->
            MovieRow(movie = movie, showFavoriteIcon = false) { movieId ->
                navController.navigate(MovieScreens.DetailScreen.name + "/$movieId")
            }
        }
    }
}