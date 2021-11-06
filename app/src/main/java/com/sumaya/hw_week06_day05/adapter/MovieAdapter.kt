package com.sumaya.hw_week06_day05.adapter


import Results
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumaya.hw_week06_day05.R

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






    }

    override fun getItemCount(): Int {

        return moviesData.size
    }

}

class CustomHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    val title :TextView = itemView.findViewById(R.id.id_title)
    val voteAverage :TextView = itemView.findViewById(R.id.id_vote_average)
    val date: TextView = itemView.findViewById(R.id.date_id)

    val posterImage :ImageView = itemView.findViewById(R.id.id_image)


}
