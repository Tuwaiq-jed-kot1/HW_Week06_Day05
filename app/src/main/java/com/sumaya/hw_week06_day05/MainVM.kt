package com.sumaya.hw_week06_day05

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM : ViewModel() {

    private val repo = MovieRepo()

    fun fetchMovies(searchKeyword: String?): LiveData<MoviesData> {
        val movies = MutableLiveData<MoviesData>()
        viewModelScope.launch {
            try {
                if (searchKeyword.isNullOrEmpty()) {
                    movies.postValue(repo.movieInfo())
                } else {
                    movies.postValue(repo.searchMovie(searchKeyword))
                }
            } catch (e: Throwable) {
                Log.e("", e.localizedMessage)
            }
        }
        return movies
    }
}