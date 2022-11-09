package com.example.train_food.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.train_food.R
import com.example.train_food.databinding.FragmentAddStopBinding
import com.example.train_food.databinding.FragmentRegisterTrainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class AddStopFragment : Fragment() {
    private lateinit var binding: FragmentAddStopBinding
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    lateinit var trainName: String
    lateinit var stopName: String
    lateinit var stopNumber: String


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
        val binding = FragmentAddStopBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            trainName= etAddTrainName.text.toString()
            stopName =etStopName.text.toString()
            stopNumber =etStopNumber.text.toString()

            btnAddStop.setOnClickListener(){
               if(formValidator()){
                   //update train docs
                  /* val ref= FirebaseFirestore.getInstance().collection("trains").document(trainName)
                   var map:HashMap<String,String> = HashMap()
                   map.put(stopName,stopNumber)

                   ref.update(map as Map<String, Any>)
                       .addOnSuccessListener {
                           Toast.makeText(requireContext(), "Stop added Successfully", Toast.LENGTH_LONG).show()
                            etStopName.text.clear()
                            etStopNumber.text.clear()

                           //  Log.d("@", "Added document with ID ${it.id}")
                       }
                       .addOnFailureListener { exception ->
                           Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_LONG).show()
                           //Log.w(TAG, "Error adding document $exception")
                       }*/
               }
            }
        }

    }

    fun formValidator(): Boolean {
        binding.apply {
            if (etAddTrainName.text.isNotBlank() && etStopName.text.isNotBlank() && etStopNumber.text.isNotBlank())
                return true
            else {
                Snackbar.make(requireView(), "All Fields are mandatory", Snackbar.LENGTH_LONG)
                    .show()
                return false
            }
        }
    }


}