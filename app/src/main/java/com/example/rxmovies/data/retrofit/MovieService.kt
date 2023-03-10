package com.example.rxmovies.data.retrofit

import com.example.rxmovies.domain.model.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieService {

    @GET("ru/API/MostPopularMovies/k_un861t3l")
    fun getPopularMovies(): Observable<Movie>

    @GET("ru/API/Top250Movies/k_un861t3l")
    fun getTop250(): Observable<Movie>

    @GET("ru/API/Images/k_un861t3l/movieId/Short")
    fun getMovieImages(movieId: String): Observable<Movie>
}