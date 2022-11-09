package com.example.train_food.DBoy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.train_food.R
import com.example.train_food.adapters.OrderAdapter
import com.example.train_food.adapters.OrderModel
import com.example.train_food.adapters.TrainAdapter
import com.example.train_food.adapters.TrainModel
import com.example.train_food.databinding.FragmentOrderListBinding

class OrderListFragment : Fragment() {
    private lateinit var binding:FragmentOrderListBinding
    private var adapter: OrderAdapter?=null
    lateinit var orderList :List<OrderModel>

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
       binding =FragmentOrderListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var testOrder:Map<String,Double> = mutableMapOf("price" to 250.0,"quantity" to 2.0)
        orderList= listOf(OrderModel("100","Ashiq Muhammed","9567563300","Vallapuzha","16350","55","S6",testOrder,2,"60"))


        adapter= OrderAdapter(requireContext(),orderList)
        binding.rvOrders.layoutManager= LinearLayoutManager(requireContext())
        binding.rvOrders.adapter=adapter
    }


}