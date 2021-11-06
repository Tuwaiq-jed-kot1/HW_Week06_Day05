package com.sumaya.hw_week06_day05.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.data.models.FlickerPhoto

class TMDBAdapter(private val photoData: List<FlickerPhoto>) :
    RecyclerView.Adapter<CustomHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tmdb_recyclerview_item, parent, false)
            //.inflate(R.layout.flicker_recyclerview_item, parent, false) //Flickr
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val photo = photoData[position]
        holder.ivFlickerImage.load(photo.url)//load is from coil lib
        holder.tvFlickerText.text=photo.title
    }

    override fun getItemCount(): Int {
        return photoData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var ivFlickerImage = itemView.findViewById<ImageView>(R.id.ivFlickerImage)
    var tvFlickerText = itemView.findViewById<TextView>(R.id.tvFlickerText)

}
