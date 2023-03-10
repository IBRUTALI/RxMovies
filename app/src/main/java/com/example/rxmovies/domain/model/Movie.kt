package com.example.rxmovies.domain.model

data class Movie(
    val errorMessage: String,
    val items: List<MovieItem>
)
