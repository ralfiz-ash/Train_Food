package com.example.train_food.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.train_food.R
import com.example.train_food.adapters.DBoyAdapter
import com.example.train_food.adapters.DeliveryBoyModel
import com.example.train_food.adapters.TrainAdapter
import com.example.train_food.adapters.TrainModel
import com.example.train_food.databinding.FragmentDBoyListBinding


class DBoyListFragment : Fragment() {
    private lateinit var binding:FragmentDBoyListBinding
    private var adapter: DBoyAdapter?=null
    lateinit var DBoyList :List<DeliveryBoyModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDBoyListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DBoyList= listOf(DeliveryBoyModel("10","Ivan Aibak","Nilambur","9676765678",""),
            DeliveryBoyModel("11","Sahal Abdul Samad","Kochi","9676765678",""),
            DeliveryBoyModel("12","Jessel","Malappuram","9676765678",""),
            DeliveryBoyModel("13","Sandheep Sing","Kaloor","9676765678",""),
            )


        adapter= DBoyAdapter(requireContext(),DBoyList)
        binding.rvBoys.layoutManager= LinearLayoutManager(requireContext())
        binding.rvBoys.adapter=adapter

    }
}