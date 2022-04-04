package com.example.mad_vo.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mad_vo.models.Movie


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow(
    movie: Movie,
    onItemClick: (String) -> Unit = {}
    ){
    var arrowSwitch by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .clickable { onItemClick(movie.id)}
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    )

    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .size(130.dp)
                    .padding(12.dp),
                elevation = 6.dp
            ){
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie picture")
            }
            Column {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}")
                Text(text = "Released: ${movie.year}")
                AnimatedVisibility(visible = arrowSwitch) {
                    Column {
                        Text(text = "Plot: ${movie.plot}", Modifier.padding(5.dp, 10.dp, 0.dp, 5.dp))
                        Text(text = "Actors: ${movie.actors}", Modifier.padding(5.dp, 5.dp, 0.dp, 0.dp))
                        Divider(color = Color.Black, thickness = 1.dp)
                        Text(text = "Genre: ${movie.genre}",  Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp))
                        Text(text = "Rating: ${movie.rating}",  Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp))
                    }

                }
                if(!arrowSwitch){
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "arrowDown",
                        modifier = Modifier.clickable { arrowSwitch = !arrowSwitch }
                    )
                }
                else{
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "arrowUp",
                        modifier = Modifier.clickable { arrowSwitch = !arrowSwitch }
                    )
                }
            }
        }
    }
}