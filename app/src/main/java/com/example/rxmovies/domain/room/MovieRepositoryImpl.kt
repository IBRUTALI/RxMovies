package com.example.rxmovies.domain.room

import com.example.rxmovies.data.room.MovieRepository
import com.example.rxmovies.data.room.dao.MovieDao
import com.example.rxmovies.domain.model.MovieItem
import io.reactivex.Single

class MovieRepositoryImpl(private val dao: MovieDao) : MovieRepository {
    override val allMovies: Single<List<MovieItem>>
        get() = dao.getAllMovies()

    override fun insertMovie(movieItem: MovieItem, onSuccess: () -> Unit) {
        dao.insertMovie(movieItem)
    }

    override fun deleteMovie(movieItem: MovieItem, onSuccess: () -> Unit) {
        dao.deleteMovie(movieItem)
    }
}