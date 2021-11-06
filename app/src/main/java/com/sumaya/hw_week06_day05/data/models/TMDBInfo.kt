package com.sumaya.hw_week06_day05.data.models

import com.google.gson.annotations.SerializedName

//data class FlickerData (//root with data type
data class MovieTitle (//root with data type
    @SerializedName("title")
    val movieTitle:String
)

//data class FlickerListPhoto( //list of photo
data class MoviePostImage(
    @SerializedName("image")
    val url:String
)


//data class FlickerPhoto (//single photo
data class MovieAverageRate (
    val title:String,
    @SerializedName("url_s")
    val url:String,
)

data class MovieDate (
    val title:String,
    @SerializedName("url_s")
    val url:String,
)