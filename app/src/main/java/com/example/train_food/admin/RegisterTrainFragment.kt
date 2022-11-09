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
import com.example.train_food.databinding.FragmentRegisterTrainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class RegisterTrainFragment : Fragment() {
    private lateinit var binding: FragmentRegisterTrainBinding
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    lateinit var trainNumber: String
    lateinit var trainName: String
    lateinit var startPoint: String
    lateinit var destinyPoint: String

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
        val binding = FragmentRegisterTrainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val fireStoreDatabase = FirebaseFirestore.getInstance()
            trainName = binding.etTrainName.text.toString()
            trainNumber = binding.etTrainNumber.text.toString()
            startPoint = binding.etStart.text.toString()
            destinyPoint = binding.etDestiny.text.toString()

            if (formValidator()) {

               /* fireStoreDatabase.collection("trains").document(trainNumber).add(obj)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "Train added", Toast.LENGTH_LONG).show()
                        binding.etTrainName.text.clear()
                        binding.etTrainNumber.text.clear()
                        binding.etStart.text.clear()
                        binding.etDestiny.text.clear()

                        //  Log.d("@", "Added document with ID ${it.id}")
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(requireContext(), "Error Occured", Toast.LENGTH_LONG).show()
                        //Log.w(TAG, "Error adding document $exception")
                    }*/
            }
        }
    }

    fun formValidator(): Boolean {
        binding.apply {
            if (etTrainName.text.isNotBlank() && etTrainNumber.text.isNotBlank() && etStart.text.isNotBlank() && etDestiny.text.isNotBlank())
                return true
            else {
                Snackbar.make(requireView(), "All Fields are mandatory", Snackbar.LENGTH_LONG)
                    .show()
                return false
            }
        }
    }

}

