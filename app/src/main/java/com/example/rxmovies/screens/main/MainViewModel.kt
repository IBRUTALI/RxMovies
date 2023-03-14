package com.example.rxmovies.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rxmovies.data.room.MovieRoomDatabase
import com.example.rxmovies.domain.model.Movie
import com.example.rxmovies.domain.retrofit.RetrofitMovieRepositoryImpl
import com.example.rxmovies.domain.room.MovieRepositoryImpl
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var context = application
    private var repository = RetrofitMovieRepositoryImpl()
    var moviesList = MutableLiveData<Movie>()

    fun getTop250(): Single<Movie> {
        return repository.getTop250()
            .map {movies ->
                moviesList.postValue(movies)
                return@map movies
            }
    }

    fun initDatabase() {
        val daoMovie = MovieRoomDatabase.getInstance(context).getMovieDao()
        val repositoryImpl = MovieRepositoryImpl(daoMovie)
    }
}