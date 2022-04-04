package com.example.mad_vo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mad_vo.models.Movie
import com.example.mad_vo.models.getMovies
import com.example.mad_vo.widgets.MovieRow

@Composable
fun DetailScreen(
        movieId: String? = "tt0499549",
        navController: NavController = rememberNavController()
        ){
        var movie = filterMovie(movieId)

        Scaffold(
                topBar = {
                        TopAppBar(backgroundColor = Color.Red, elevation = 3.dp){
                                Row{
                                        Icon(imageVector = Icons.Default.ArrowBack,
                                                contentDescription = "Arrow Back",
                                                modifier = Modifier.clickable {
                                                        navController.popBackStack()
                                                })
                                        Spacer(modifier = Modifier.width(20.dp))

                                        Text(text = movie.title)
                                }
                        }
                }
        ) {
                MainContent(movie = movie)
                Text("TTTTTZZZZZ")
        }
}

@Composable
fun MainContent(movie: Movie){
        MovieRow(movie = movie)
}

fun filterMovie(movieId: String?) : Movie{
        return getMovies().filter { it.id == movieId }[0]
}