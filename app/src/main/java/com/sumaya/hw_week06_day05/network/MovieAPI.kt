package com.sumaya.hw_week06_day05.network

import MoviesData
import com.sumaya.hw_week06_day05.BuildConfig
//import com.sumaya.hw_week06_day05.MovieDB_API
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/popular?api_key=${BuildConfig.MovieDB_API}&language=en-US&page=1")
    suspend fun fetchMovie():MoviesData

    @GET("search/movie?api_key=${BuildConfig.MovieDB_API}&language=en-US&page=1&include_adult=false")
        suspend fun searchMovie(@Query("query") searchKeyword:String): MoviesData

}

