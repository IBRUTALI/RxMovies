package com.example.rxmovies.domain

sealed class State {
    object Loading: State()
    class Error(val text: String): State()
    object Success: State()
    object Empty: State()
}