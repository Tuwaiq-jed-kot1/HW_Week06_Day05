package com.sumaya.hw_week06_day05.adapter

/*
import Results
import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.WebViewActivity


class MovieAdapter(val moviesData: List<Results>/*, val image:List<PathImage>*/) : RecyclerView.Adapter<CustomHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent,false)
        return CustomHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomHolder, position: Int) {


        val movie= moviesData[position]

        holder.title.text="${movie.title}"
        holder.date.text=" ${movie.release_date}"
        holder.posterImage.load("https://image.tmdb.org/t/p/w500"+movie.poster_path)
        holder.voteAverage.text=" ${movie.vote_average}"
        holder.idTV=movie.id.toString()

    }

    override fun getItemCount(): Int {

        return moviesData.size
    }

}



class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
    val title: TextView = itemView.findViewById(R.id.id_title)
    val voteAverage: TextView = itemView.findViewById(R.id.id_vote_average)
    val date: TextView = itemView.findViewById(R.id.date_id)
    val posterImage: ImageView = itemView.findViewById(R.id.id_image)
    lateinit var idTV: String

    init {
        posterImage.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(v.context, WebViewActivity::class.java)
        intent.putExtra("A", "idTV")
        v.context.startActivity(intent)
    }
}*/



import Results
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R
import com.sumaya.hw_week06_day05.WebViewActivity


class MovieAdapter(val moviesData:List<Results>) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)
        return CustomHolder(view)

    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movies = moviesData[position]
        holder.textTitle.text = movies.title
        holder.textDate.text = movies.release_date
        holder.textVotes.text = movies.vote_average.toString()
        holder.poster.load("https://image.tmdb.org/t/p/w500"+movies.poster_path)
        holder.idTV = movies.id.toString()

    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
    val textTitle: TextView = itemView.findViewById(R.id.id_title)
    val textDate: TextView = itemView.findViewById(R.id.date_id)
    val textVotes: TextView = itemView.findViewById(R.id.id_vote_average)
    val poster: ImageView = itemView.findViewById(R.id.id_image)
    lateinit var idTV: String
    init {
        poster.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(v.context, WebViewActivity::class.java)
        intent.putExtra("id",idTV)
        v.context.startActivity(intent)
    }
}