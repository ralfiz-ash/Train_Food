package com.example.train_food.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.train_food.R
import com.example.train_food.adapters.FoodAdapter
import com.example.train_food.adapters.FoodModel
import com.example.train_food.adapters.TrainAdapter
import com.example.train_food.adapters.TrainModel
import com.example.train_food.databinding.FragmentRegisterTrainBinding
import com.example.train_food.databinding.FragmentTrainListBinding

class TrainListFragment : Fragment() {
   private lateinit var binding:FragmentTrainListBinding
    private var adapter: TrainAdapter?=null
    lateinit var trainList :List<TrainModel>

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
       binding=FragmentTrainListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trainList= listOf(TrainModel("16349","16349","RajyaRani Express","Kochuveli","Nilambur"),
            TrainModel("16350","16350","RajyaRani Express","Nilambur","Kochuveli"),
            TrainModel("16378","16378","Madurai Express","Madurai","punalur"),
            TrainModel("14543","14543","Maveli Express","Trivandrum","Calicut"))


        adapter= TrainAdapter(requireContext(),trainList)
        binding.rvTrain.layoutManager=LinearLayoutManager(requireContext())
        binding.rvTrain.adapter=adapter
    }

}