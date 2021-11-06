package com.sumaya.hw_week06_day05.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TMDBRepo { //use coroutines to work in background so we don't get main thread exception
   // private val tag="FlickerRepo"
    private val tag="TMDBRepo"
    //private val api = FlickerBuilder.flickerAPI //created instance
    private val api = TMDBBuilder.flickerAPI //created instance

    //suspend fun fetchInterestingList(): FlickerData = withContext(Dispatchers.IO){
    suspend fun fetchInterestingList(): TMDBData = withContext(Dispatchers.IO){
        api.fetchPhotos()
    }

    //suspend fun searchPhotos(searchKeyword:String): FlickerData = withContext(Dispatchers.IO){
    suspend fun searchPhotos(searchKeyword:String): TMDBData = withContext(Dispatchers.IO){
        api.searchPhotos(searchKeyword)
    }

}