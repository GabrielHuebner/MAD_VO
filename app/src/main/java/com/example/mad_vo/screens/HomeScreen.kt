package com.example.mad_vo.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import com.example.mad_vo.models.Movie
import com.example.mad_vo.models.getMovies
import com.example.mad_vo.navigation.MovieScreens
import com.example.mad_vo.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavHostController) {

    var showMenu by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Movies") },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }

                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "favorites",
                                    modifier = Modifier.padding(4.dp)
                                )
                                Text(
                                    text = "Favorites",
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .width(100.dp)
                                )
                            }
                        }
                    }
                }
            )
        }
    ) {
        MainContent(movies = getMovies(), navController)
    }
}

@Composable
fun MainContent(movies: List<Movie> = getMovies(), navController: NavHostController){
    LazyColumn{
        items(movies) {
                movie -> MovieRow(movie = movie){ movieId ->
                            Log.d("MainContent", "My callback value: $movieId")
                            navController.navigate(MovieScreens.DetailScreen.name + "/$movieId")
                        }
        }
    }
}