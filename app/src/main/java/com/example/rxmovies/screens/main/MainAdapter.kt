package com.example.rxmovies.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rxmovies.R
import com.example.rxmovies.databinding.ItemMovieBinding
import com.example.rxmovies.domain.model.MovieItem

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var moviesList = emptyList<MovieItem>()

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)

        fun bind(item: MovieItem) {
            with(binding) {
                title.text = item.title
                date.text = item.year
                imdb.text = if (item.imDbRating.isNotEmpty()) {
                    item.imDbRating
                } else {
                    "0.0"
                }
                Glide.with(title.context)
                    .load(item.image)
                    .centerCrop()
                    .placeholder(null)
                    .into(imgItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setItems(list: List<MovieItem>) {
        moviesList = list
        notifyDataSetChanged()
    }

}