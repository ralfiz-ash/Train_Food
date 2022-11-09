package com.example.train_food.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.train_food.R
import com.example.train_food.databinding.FragmentAddFoodBinding
import com.example.train_food.databinding.FragmentAddStopBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class AddFoodFragment : Fragment() {
    private lateinit var binding: FragmentAddFoodBinding
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    lateinit var foodImgUrl: String
    lateinit var foodName: String
    lateinit var foodPrice: String

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
        val binding = FragmentAddFoodBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnAddFood.setOnClickListener(){
                foodName=etFoodName.text.toString()
                foodPrice=etFoodPrice.text.toString()
                if (formValidator()) {


                }
                }

            }

        }

    fun formValidator(): Boolean {
        binding.apply {
            if (etFoodName.text.isNotBlank() && etFoodPrice.text.isNotBlank())
                return true
            else {
                Snackbar.make(requireView(), "All Fields are mandatory", Snackbar.LENGTH_LONG)
                    .show()
                return false
            }
        }
    }
}