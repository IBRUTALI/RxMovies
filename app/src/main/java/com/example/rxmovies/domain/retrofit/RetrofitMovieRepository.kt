package com.example.rxmovies.domain.retrofit

import com.example.rxmovies.domain.model.Movie
import io.reactivex.Observable
import retrofit2.Response

interface RetrofitMovieRepository {
   fun getPopularMovies(): Observable<Movie>

   fun getTop250(): Observable<Movie>

   fun getMovieImages(movieId: String): Observable<Movie>

}