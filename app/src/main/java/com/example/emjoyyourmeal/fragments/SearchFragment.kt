package com.example.emjoyyourmeal.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emjoyyourmeal.R
import com.example.emjoyyourmeal.adapter.MenuAdapter
import com.example.emjoyyourmeal.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalFoodMenu = listOf("burger", "sandwich", "momo", "item", "sandwich", "mamo")
    private val originalFoodPrice = listOf("Rs.320", "Rs.450", "Rs.270", "Rs.540", "Rs.650", "Rs.350")
    private val originalFoodImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6
    )

    private val filteredMenuItem = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuItemImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuItem, filteredMenuItemPrice, filteredMenuItemImage)
        binding.searchRecycle.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecycle.adapter = adapter
        // searchview function
        setupSearchView()
        // populate initial menu
        populateFilteredMenu(originalFoodMenu, originalFoodPrice, originalFoodImage)
        return binding.root
    }

    private fun populateFilteredMenu(menu: List<String>, prices: List<String>, images: List<Int>) {
        filteredMenuItem.addAll(menu)
        filteredMenuItemPrice.addAll(prices)
        filteredMenuItemImage.addAll(images)
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { filterMenuItem(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { filterMenuItem(it) }
                return true
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterMenuItem(query: String) {
        filteredMenuItem.clear()
        filteredMenuItemPrice.clear()
        filteredMenuItemImage.clear()
        originalFoodMenu.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuItem.add(foodName)
                filteredMenuItemPrice.add(originalFoodPrice[index])
                filteredMenuItemImage.add(originalFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
}
