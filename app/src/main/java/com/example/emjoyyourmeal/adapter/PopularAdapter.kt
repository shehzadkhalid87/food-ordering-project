package com.example.emjoyyourmeal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.emjoyyourmeal.databinding.PopulariemBinding

class PopularAdapter ( private val items:List<String>,private val price: List<String>,private val image:List<Int> ):RecyclerView.Adapter <PopularAdapter.PopularViewhonlder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewhonlder {
        return PopularViewhonlder(PopulariemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewhonlder, position: Int) {
        val item = items[position]
        val image = image[position]
        val price = price[position]
        holder.bind(item,image,price)
    }
    class PopularViewhonlder (private val binding: PopulariemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imagesview = binding.foodimg
        fun bind(item: String, image: Int,price:String) {
            binding.foodname.text = item
            binding.pricepopular.text = price
            imagesview.setImageResource(image)
        }

    }

}

