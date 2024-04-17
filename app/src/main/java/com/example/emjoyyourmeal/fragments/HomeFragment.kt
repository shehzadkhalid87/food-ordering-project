package com.example.emjoyyourmeal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView.ScaleType
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.example.emjoyyourmeal.R
import com.denzcoskun.imageslider.models.SlideModel
import com.example.emjoyyourmeal.MenuFragment
import com.example.emjoyyourmeal.adapter.PopularAdapter
import com.example.emjoyyourmeal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.viewMenu.setOnClickListener{
            val bottomSheetDialog = MenuFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        var imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPostion = imageList[position]
                val itemMessage = "Slected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }

        })
        val FoodName = listOf("Burger","Sandwich","Momo","item")
        val price = listOf("Rs.500","Rs.440","Rs.420","Rs.320")
        val popularfoodimage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)
        val  apdater = PopularAdapter(FoodName,price,popularfoodimage)
        binding.popularRec.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRec.adapter = apdater
    }

    companion object {

    }
}

