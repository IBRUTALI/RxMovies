package com.example.rxmovies.data.room

import com.example.rxmovies.domain.model.MovieItem
import io.reactivex.Single

interface MovieRepository {
    val allMovies: Single<List<MovieItem>>

    fun insertMovie(movieItem: MovieItem, onSuccess:() -> Unit)

    fun deleteMovie(movieItem: MovieItem, onSuccess:() -> Unit)
}