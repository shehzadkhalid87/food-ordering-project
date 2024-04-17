package com.example.emjoyyourmeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emjoyyourmeal.adapter.MenuAdapter
import com.example.emjoyyourmeal.databinding.FragmentMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentMenuBinding.inflate(inflater,container,false)
        binding.backbtn.setOnClickListener{
            dismiss()
        }

        val MenuFoodName= listOf("burger","sandwich", "momo", "item" ,"sandwich","mamo")
        val MenuFoodprice= listOf("Rs.320","Rs.450", "Rs.270", "Rs.540" ,"Rs.650","Rs.350")
        val menuimage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7)
        val  apdater = MenuAdapter(ArrayList(MenuFoodName),ArrayList(MenuFoodprice),ArrayList(menuimage))
        binding.MenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.MenuRecyclerView.adapter = apdater
        return binding.root
    }

    companion object {

    }
}