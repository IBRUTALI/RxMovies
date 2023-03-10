package com.example.rxmovies.domain.retrofit

import com.example.rxmovies.domain.model.Movie
import io.reactivex.Observable

class RetrofitMovieRepositoryImpl : RetrofitMovieRepository {
    override fun getPopularMovies(): Observable<Movie> {
        return RetrofitMovieInstance.api.getPopularMovies()
    }

    override fun getTop250(): Observable<Movie> {
        return RetrofitMovieInstance.api.getTop250()
    }

    override fun getMovieImages(movieId: String): Observable<Movie> {
        return RetrofitMovieInstance.api.getMovieImages(movieId)
    }
}