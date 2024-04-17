package com.example.emjoyyourmeal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emjoyyourmeal.databinding.CartitemBinding

class CartAdapter(
    private val cartItem: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private val cartImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItem.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItem.size

    inner class CartViewHolder(private val binding: CartitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val cartQuantity = itemQuantities[position]
                CartFoodName.text = cartItem[position]
                CartItemPrice.text = cartItemPrice[position]
                CartImage.setImageResource(cartImage[position])
                cartItemQuantity.text = itemQuantities[position].toString()

                minusbtn.setOnClickListener {
                    decreaseQuantity(position)

                }
                plusbtn.setOnClickListener {
                    increasequantity(position)

                }
                deletebtn.setOnClickListener {
                    val itemposition = adapterPosition
                    if (itemposition!= RecyclerView.NO_POSITION){
                        deleteitem(itemposition)
                    }


                }
            }
        }
       private fun increasequantity(position: Int) {
            if (itemQuantities[position] < 15) {
                itemQuantities[position]++
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }

        }
        private fun decreaseQuantity(position: Int){
            if (itemQuantities [position]>1){
                itemQuantities[position]--
                binding.cartItemQuantity.text=itemQuantities[position].toString()
            }
        }
        private fun deleteitem (position: Int){
            cartItem.removeAt(position)
            cartImage.removeAt(position)
            cartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItem.size)
        }
    }

}