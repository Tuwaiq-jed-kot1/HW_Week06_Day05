package com.sumaya.hw_week06_day05.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sumaya.hw_week06_day05.R

class MainActivity : AppCompatActivity() {
    private val viewModel: mainVM by lazy {
        ViewModelProvider(this)[mainVM::class.java]
    }

    private lateinit var sharedPreferences: SharedPreferences
    private val SHARED_KEY = "LastSearch"

    //private lateinit var rvFlicker: RecyclerView
    private lateinit var rvTMDB: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //rvFlicker = findViewById(R.id.rvFlicker)
        rvTMDB = findViewById(R.id.rvTMDB)
        rvTMDB.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //sharedPreferences = this.getSharedPreferences("flickrSearchSharedPreference", Context.MODE_PRIVATE)
        sharedPreferences = this.getSharedPreferences("TMDBSearchSharedPreference", Context.MODE_PRIVATE)
        loadTMDBInfos()
    }

    //fun loadFlickerImages(query: String? = null) {
    fun loadTMDBInfos(query: String? = null) {
        viewModel.fetchInterestingList(query).observe(this, {
            if (query.isNullOrEmpty()) {
                rvTMDB.adapter = TMDBAdapter(it.flickerListPhoto.listOfPhotos)
            } else {
                rvTMDB.swapAdapter(TMDBAdapter(it.flickerListPhoto.listOfPhotos), false)
            }
            //Log.d("flicker main response", "helo")
            Log.d("TMDB main response", "Ola")
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchIcon: MenuItem = menu!!.findItem(R.id.app_bar_search)
        val searchView = searchIcon.actionView as SearchView
        val TAG = "search view"
        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    loadTMDBInfos(query!!.trim())
                    val sharePref = sharedPreferences.getString(SHARED_KEY, "This was your first search!! Yay!!")
                    Log.d(TAG, "QueryTextSubmit: $query")
                    Toast.makeText(context, sharePref, Toast.LENGTH_SHORT).show()
                    sharedPreferences
                        .edit()
                        .putString(SHARED_KEY, "Your last search was: $query")
                        .apply()
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    Log.d(TAG, "QueryTextChange: $newText")
                    return false
                }


            })

        }



        return super.onCreateOptionsMenu(menu)
    }
}