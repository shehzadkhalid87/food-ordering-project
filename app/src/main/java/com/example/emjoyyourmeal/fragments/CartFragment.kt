package com.example.emjoyyourmeal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emjoyyourmeal.R
import com.example.emjoyyourmeal.adapter.CartAdapter
import com.example.emjoyyourmeal.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName= listOf("burger","sandwich", "momo", "item" ,"sandwich","mamo")
        val cartFoodprice= listOf("Rs.320","Rs.450", "Rs.270", "Rs.540" ,"Rs.650","Rs.350")
        val foodimage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7)
        val  apdater = CartAdapter(ArrayList(cartFoodName),ArrayList(cartFoodprice),ArrayList(foodimage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = apdater

        return binding.root
    }



}