package com.example.mad_vo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mad_vo.models.Movie
import com.example.mad_vo.models.getMovies
import com.example.mad_vo.viewmodels.FavoriteViewModel
import com.example.mad_vo.widgets.FavoriteIcon
import com.example.mad_vo.widgets.HorizontalScrollImageView
import com.example.mad_vo.widgets.MovieRow

@Composable
fun DetailScreen(
        movieId: String? = "tt0499549",
        navController: NavController = rememberNavController(),
        viewModel: FavoriteViewModel
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
                MainContent(movie = movie, viewModel)
        }
}

@Composable
fun MainContent(movie: Movie, viewModel: FavoriteViewModel){
        Surface(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
                Column() {
                        MovieRow(
                                movie = movie,
                                showFavoriteIcon = true,
                                content = {
                                        FavoriteIcon(movie = movie, isFavorite = viewModel.isFavorite(movie = movie)) {
                                                        movie ->
                                                if ( ! viewModel.addFavorite( movie = movie ) ) viewModel.removeFavorite( movie = movie )
                                        }
                                }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider()
                        Text(
                                text = "Movie Images",
                                modifier = Modifier
                                        .align(Alignment.CenterHorizontally),
                                style = MaterialTheme.typography.h5
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalScrollImageView(movie = movie)
                }
        }
}

fun filterMovie(movieId: String?) : Movie{
        return getMovies().filter { it.id == movieId }[0]
}