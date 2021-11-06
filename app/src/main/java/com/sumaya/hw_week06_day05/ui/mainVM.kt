package com.sumaya.hw_week06_day05.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumaya.hw_week06_day05.data.network.TMDBRepo
import kotlinx.coroutines.launch

class mainVM : ViewModel() {

    //val repo = FlickerRepo()
    val repo = TMDBRepo()
    //fun fetchInterestingList(searchKeyword: String? = null): LiveData<FlickerData> {
    fun fetchInterestingList(searchKeyword: String? = null): LiveData<TMDBInfo> {
        //val photos = MutableLiveData<FlickerData>()
        val photos = MutableLiveData<TMDBInfo>()
        viewModelScope.launch {
            try {
                if (searchKeyword.isNullOrEmpty()) {
                    photos.postValue(repo.fetchInterestingList())
                } else {
                    photos.postValue(repo.searchPhotos(searchKeyword))
                }
            } catch (t: Throwable) {
                Log.e("Flicker image exception", t.localizedMessage)
            }
        }
        return photos
    }
}