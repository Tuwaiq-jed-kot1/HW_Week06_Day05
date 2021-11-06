package com.sumaya.hw_week06_day05

data class MoviesData(
    val movies: List<Results>
)

data class Results(val original_title: String,
                 val poster_path: String,
                 val vote_average: Double,
                 val release_date: String)
