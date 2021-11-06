package com.sumaya.hw_week06_day05
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tuwaiq.restandretrofit.data.network.models.Results


class FlickrAdapter(val moviesData:List<Results> ) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_item,parent,false)
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val movies = moviesData[position]
        holder.textTitle.text = movies.title
        holder.textDate.text = movies.release_date
        holder.textVotes.text = movies.vote_average.toString()
        holder.Poster.load("https://image.tmdb.org/t/p/w500"+movies.poster_path)
    }

    override fun getItemCount(): Int {
        return moviesData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val textTitle: TextView = itemView.findViewById(R.id.txtTitle)
    val textDate: TextView = itemView.findViewById(R.id.txtDate)
    val textVotes: TextView = itemView.findViewById(R.id.txtVotes)
    val Poster: ImageView = itemView.findViewById(R.id.ivPoster)


}