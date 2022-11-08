package com.example.train_food.Passenger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.train_food.R
import com.example.train_food.adapters.FoodAdapter
import com.example.train_food.adapters.FoodModel
import com.example.train_food.databinding.FragmentCartBinding

class demo1Fragment : Fragment() {
    private lateinit var binding:FragmentCartBinding
    private var adapter: FoodAdapter?=null
    lateinit var foodList :List<FoodModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCartBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodList= listOf(
            FoodModel("101","Burger","60","",false),
            FoodModel("102","Broast","80","",false),
            FoodModel("103","Tea","20","",false),
            FoodModel("104","Cofee","30","",false),
            FoodModel("105","Water","20","",false)
        )


        adapter= FoodAdapter(requireContext(),foodList)
        binding.rvCart.layoutManager= GridLayoutManager(requireContext(),2)
        binding.rvCart.adapter=adapter

    }


}