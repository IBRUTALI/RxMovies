package com.example.rxmovies.data.room.dao

import androidx.room.*
import com.example.rxmovies.domain.model.MovieItem
import io.reactivex.Single

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movieItem: MovieItem)
    @Delete
    fun deleteMovie(movieItem: MovieItem)
    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): Single<List<MovieItem>>

}