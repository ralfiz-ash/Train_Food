package com.example.train_food.Passenger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.train_food.R
import com.example.train_food.adapters.FoodAdapter
import com.example.train_food.adapters.FoodModel
import com.example.train_food.databinding.FragmentFoodHomeBinding
import com.example.train_food.databinding.FragmentHomeBinding

class FoodHomeFragment : Fragment() {
    private lateinit var binding:FragmentFoodHomeBinding
    private var adapter: FoodAdapter?=null
    lateinit var foodList :List<FoodModel>
   // private var isMoved:Boolean=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFoodHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodList= listOf(FoodModel("101","Burger","60","",false),
            FoodModel("102","Broast","80","",false),
            FoodModel("103","Tea","20","",false),
            FoodModel("104","Cofee","30","",false),
            FoodModel("105","Water","20","",false))


        adapter= FoodAdapter(requireContext(),foodList)
        binding.rvFoodMenu.layoutManager= GridLayoutManager(requireContext(),2)
        binding.rvFoodMenu.adapter=adapter


    }
}