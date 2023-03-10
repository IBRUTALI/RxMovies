package com.example.rxmovies.domain.retrofit

import com.example.rxmovies.BASE_URL
import com.example.rxmovies.data.retrofit.MovieService
import com.example.rxmovies.domain.model.Movie
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitMovieInstance{

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
}