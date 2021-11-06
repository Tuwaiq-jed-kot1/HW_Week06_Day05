package com.sumaya.hw_week06_day05.data.network

import com.sumaya.hw_week06_day05.data.models.FlickerData
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBAPI {//DAO!

    //@GET("?method=flickr.interestingness.getList&api_key=${BuildConfig.flickerAPIKey}&format=json&nojsoncallback=1&extras=url_s")
    @GET("?method=flickr.interestingness.getList&api_key=${BuildConfig.flickerAPIKey}&format=json&nojsoncallback=1&extras=url_s")
    //suspend fun fetchPhotos(): FlickerData
    suspend fun fetchPhotos(): TMDBInfo

    //@GET("?method=flickr.photos.search&api_key=${BuildConfig.flickerAPIKey}&format=json&nojsoncallback=1&extras=url_s&safe_search=1")
    @GET("?method=flickr.photos.search&api_key=${BuildConfig.flickerAPIKey}&format=json&nojsoncallback=1&extras=url_s&safe_search=1")
    suspend fun searchPhotos(@Query("text")searchKeyword:String): FlickerData//word text is key and it will add &text=$searchKeyword to the url


}