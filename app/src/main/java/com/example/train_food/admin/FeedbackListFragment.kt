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
import com.example.train_food.adapters.FeedbackAdapter
import com.example.train_food.adapters.FeedbackModel
import com.example.train_food.adapters.TrainAdapter
import com.example.train_food.adapters.TrainModel
import com.example.train_food.databinding.FragmentFeedbackListBinding


class FeedbackListFragment : Fragment() {
    private lateinit var binding:FragmentFeedbackListBinding
    private var adapter: FeedbackAdapter?=null
    lateinit var feedbackList :List<FeedbackModel>

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
       binding=FragmentFeedbackListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedbackList= listOf(FeedbackModel("1","Ashiq","Adequate informations should be provide for more flexible an it improve efficiency","4"),
            FeedbackModel("2","Nithin","Adequate informations should be provide for more flexible an it improve efficiency","4"),
            FeedbackModel("3","Zenith","Adequate informations should be provide for more flexible an it improve efficiency","5"),
            FeedbackModel("4","Vishnu","Adequate informations should be provide for more flexible an it improve efficiency","4.5"))

        adapter= FeedbackAdapter(requireContext(),feedbackList)
        binding.rvFeedbacks.layoutManager= LinearLayoutManager(requireContext())
        binding.rvFeedbacks.adapter=adapter

    }

}