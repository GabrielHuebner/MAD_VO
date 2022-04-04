package com.example.mad_vo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mad_vo.models.Movie
import com.example.mad_vo.models.getMovies
import com.example.mad_vo.widgets.HorizontalScrollImageView
import com.example.mad_vo.widgets.MovieRow

@Composable
fun DetailScreen(
        movieId: String? = "tt0499549",
        navController: NavController = rememberNavController()
        ){
        var movie = filterMovie(movieId)

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

                                        Text(text = movie.title)
                                }
                        }
                }
        ) {
                MainContent(movie = movie)
        }
}

@Composable
fun MainContent(movie: Movie){
        Surface(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                Column {
                        MovieRow(movie = movie)
                        HorizontalScrollImageView(movie = movie)
                }
        }
}

fun filterMovie(movieId: String?) : Movie{
        return getMovies().filter { it.id == movieId }[0]
}