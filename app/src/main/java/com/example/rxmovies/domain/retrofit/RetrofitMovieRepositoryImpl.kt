package com.example.rxmovies.domain.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.rxmovies.domain.model.Movie
import io.reactivex.Observable
import io.reactivex.Single

class RetrofitMovieRepositoryImpl : RetrofitMovieRepository {
    override fun getPopularMovies(): Single<Movie> {
        return RetrofitMovieInstance.api.getPopularMovies()
    }

    override fun getTop250(): Single<Movie> {
        return RetrofitMovieInstance.api.getTop250()
    }

    override fun getMovieImages(movieId: String): Single<Movie> {
        return RetrofitMovieInstance.api.getMovieImages(movieId)
    }
}