package com.sumaya.hw_week06_day05

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepo {
    private val api = MovieBuilder.tmdbAPI

    suspend fun movieInfo(): MoviesData = withContext(Dispatchers.IO){
        api.fetchPopularMovies()
    }

    suspend fun searchMovie(searchKeyword: String): MoviesData = withContext(Dispatchers.IO) {
        api.searchMovie(searchKeyword)
    }
}