package com.example.train_food.Passenger

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.train_food.MainActivity
import com.example.train_food.R
import com.example.train_food.adapters.FoodAdapter
import com.example.train_food.adapters.FoodModel
import com.example.train_food.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var isMoved: Boolean = false

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
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.icon.setOnClickListener() {
            isMoved = if (isMoved) {
                Log.d("!", "onClicked")
                MainActivity.instance?.get()?.hideFragment()
                false
            } else {
                MainActivity.instance?.get()?.moveFragment()
                true
            }

        }

        binding.iconMenu.setOnClickListener() {
            setStartDestination(R.id.foodListFragment2)
        }
        binding.iconHome.setOnClickListener() {
            Log.d("@", "onViewCreated: home clicked")
            setStartDestination(R.id.foodHomeFragment)
        }
        binding.iconOrder.setOnClickListener() {
            setStartDestination(R.id.orderListFragment2)
        }
        binding.iconFeedback.setOnClickListener(){
            setStartDestination(R.id.feedbackFragments)
        }
        binding.iconCart.setOnClickListener() {
            setStartDestination(R.id.cartFragment)
        }

    }

    private fun setStartDestination(id: Int) {
        val controller = binding.fragmentHomeContainer.findNavController()
        val graph = controller.navInflater.inflate(R.navigation.nested_navgraph)
        graph.setStartDestination(id)
        controller.graph = graph
    }

}