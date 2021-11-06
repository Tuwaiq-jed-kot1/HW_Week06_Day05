package com.sumaya.hw_week06_day05.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.Results

class TMDBAdapter(val movieData: List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tmdb_recycler_view, parent, false)
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movie = movieData[position]
        holder.movieTitle.text = movie.title
        holder.releaseDate.text = movie.release_date
        holder.averageVotes.text = movie.vote_average.toString()
        holder.movieImage.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val movieImage: ImageView = itemView.findViewById(R.id.movieImageIV)
    val movieTitle: TextView = itemView.findViewById(R.id.movieTitleTV)
    val releaseDate: TextView = itemView.findViewById(R.id.releaseDateTV)
    val averageVotes: TextView = itemView.findViewById(R.id.averageVotesTV)
}
