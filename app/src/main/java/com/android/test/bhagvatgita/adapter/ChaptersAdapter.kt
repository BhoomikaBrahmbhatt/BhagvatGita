package com.android.test.bhagvatgita.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.test.bhagvatgita.databinding.AdapterChaptersBinding
import com.android.test.bhagvatgita.mvvm.Chapters
import com.bumptech.glide.Glide

class ChaptersAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var chapters = mutableListOf<Chapters>()
    fun setMovieList(chapters: List<Chapters>) {
        this.chapters = chapters.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterChaptersBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val chapter = chapters[position]
        val name=chapter.name
        holder.binding.name.text = "${position.plus(1)}. $name"
       // Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {
        return chapters.size
    }
}
class MainViewHolder(val binding: AdapterChaptersBinding) : RecyclerView.ViewHolder(binding.root) {
}