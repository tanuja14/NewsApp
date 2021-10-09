package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList

class NewsListAdapter(private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder=NewsViewHolder(view)
        view.setOnClickListener{
         listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem=items[position]
        holder.titleView.text=currentItem.title
        holder.Description.text=currentItem.description
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.Image)
    }

    fun updatedNews(updatedNews:ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }


}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView=itemView.findViewById(R.id.title)
    val Image: ImageView=itemView.findViewById(R.id.image)
    val Description:TextView=itemView.findViewById(R.id.description)
}

interface NewsItemClicked{
    fun onItemClicked(item:News)


}