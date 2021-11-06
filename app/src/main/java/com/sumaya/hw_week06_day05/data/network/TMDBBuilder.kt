package com.sumaya.hw_week06_day05.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TMDBBuilder { //singleton object to connect to service //instead of db in Room //to make an instance

    private const val BASE_URL =
        //"https://api.flickr.com/services/rest/" //this part of url is repetitive so we made it const
        //"https://api.themoviedb.org/3/movie/popular?api_key=PUT_YOUR_KEY&language=en-US&page=1" //this part of url is repetitive so we made it const
        "https://api.themoviedb.org/3/movie/popular?api_key=e52dff54cc39579bc2a117b18b82c92f&language=en-US&page=1" //this part of url is repetitive so we made it const

    private fun retrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())//convert for gson to our data classes
            .build()

    //val flickerAPI:FlickerAPI= retrofit().create(FlickerAPI::class.java)//instance of flickerAPI interface created when we call builder
    val flickerAPI:TMDBAPI= retrofit().create(TMDBAPI::class.java)//instance of TMDBAPI interface created when we call builder

}