package com.example.rxmovies.domain.retrofit

import com.example.rxmovies.domain.model.Movie
import io.reactivex.Single

interface RetrofitMovieRepository {
   fun getPopularMovies(): Single<Movie>

   fun getTop250(): Single<Movie>

   fun getMovieImages(movieId: String): Single<Movie>

}