package com.example.rxmovies.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rxmovies.data.room.dao.MovieDao
import com.example.rxmovies.domain.model.MovieItem

@Database(entities = [MovieItem::class], version = 1)
abstract class MovieRoomDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

    companion object {
        private var database: MovieRoomDatabase? = null

        fun getInstance(context: Context): MovieRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, MovieRoomDatabase::class.java, "db_movie")
                    .build()
                database as MovieRoomDatabase
            } else {
                database as MovieRoomDatabase
            }
        }
    }

}