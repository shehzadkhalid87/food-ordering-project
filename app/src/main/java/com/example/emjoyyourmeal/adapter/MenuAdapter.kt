package com.example.emjoyyourmeal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emjoyyourmeal.databinding.MenuBinding

class MenuAdapter(
    private val MenuItem: List<String>,
    private val MenuItemPrice: List<String>,
    private val Menuimage: MutableList<Int>

    ) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = MenuItem.size
    inner class MenuViewHolder(private val binding: MenuBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                MenuItemName.text = MenuItem[position]
                Menuitemprice.text = MenuItemPrice[position]
                MenuImg.setImageResource(Menuimage[position])

            }

        }

    }
}