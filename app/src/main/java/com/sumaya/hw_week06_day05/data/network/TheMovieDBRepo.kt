package com.sumaya.hw_week06_day05.data.network

import com.sumaya.hw_week06_day05.data.model.TheMovieDBData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TheMovieDBRepo {
    private val api = TheMovieDBBuilder.movieDBApi

    suspend fun fetchInterestingList(): TheMovieDBData = withContext(Dispatchers.IO) {
        api.fetchMovies()
    }
//    suspend fun deleteMovieList(): TheMovieDBData = withContext(Dispatchers.IO) {
//        api.deleteMovies()
//    }
    suspend fun searchMovies(searchKeyword: String): TheMovieDBData = withContext(Dispatchers.IO) {
        api.searchMovies(searchKeyword)
    }
}