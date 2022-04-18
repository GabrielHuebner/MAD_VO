package com.example.mad_vo.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mad_vo.models.Movie

class FavoriteViewModel : ViewModel(){
    private var favorites = mutableStateListOf<Movie>()

    fun addFavorite(movie: Movie) : Boolean{
        if(!favorites.contains(movie)){
            favorites.add(movie)
            return true
        }
        return false
    }

    fun removeFavorite(movie: Movie){
        if(favorites.contains(movie)){
            favorites.remove(movie)
        }
    }

    fun getAllFavorites() : List<Movie>{
        return favorites
    }

    fun isFavorite(movie: Movie) : Boolean{
        return favorites.contains(movie)
    }
}