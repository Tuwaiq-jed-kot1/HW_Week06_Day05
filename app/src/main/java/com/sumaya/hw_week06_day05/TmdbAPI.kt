package com.sumaya.hw_week06_day05

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {
    @GET("movie/popular?api_key=a3e933b7aa31f36734c7f5ac088d6b8e&language=en-US&page=1")
    suspend fun fetchPopularMovies(): MoviesData

    @GET("search/movie?api_key=a3e933b7aa31f36734c7f5ac088d6b8e&language=en-US&page=1&include_adult=false")
    suspend fun searchMovie(@Query("query") searchKeyword: String): MoviesData
}