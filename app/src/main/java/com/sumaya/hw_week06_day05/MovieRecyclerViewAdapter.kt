package com.sumaya.hw_week06_day05

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class MovieRecyclerViewAdapter(private val movieList: List<Results>) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.movieTitleTV)
        val posterImage: ImageView = itemView.findViewById(R.id.moviePosterIV)
        val releaseDate: TextView = itemView.findViewById(R.id.releaseDateTV)
        val averageVote: TextView = itemView.findViewById(R.id.averageVoteTV)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_recyclerview_item,parent,false)
        Log.d("555555555", "movieList.toString()")

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.posterImage.load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
        holder.title.text = movie.original_title
        holder.releaseDate.text = movie.release_date
        holder.averageVote.text = movie.vote_average.toString()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}