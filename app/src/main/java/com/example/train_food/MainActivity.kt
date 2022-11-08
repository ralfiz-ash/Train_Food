package com.example.train_food

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.train_food.databinding.ActivityMainBinding
import java.lang.ref.WeakReference
import kotlin.properties.Delegates

public var width by Delegates.notNull<Int>()
public var height by Delegates.notNull<Int>()


class MainActivity : AppCompatActivity() {
    companion object {
        var instance: WeakReference<MainActivity>? = null
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        this?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //findNavController().navigateUp()
            }
        })
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instance = WeakReference(this)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels
        Log.d("device", "Device width& Height :- ${width},${height}")

        binding.apply {
            ivClose.setOnClickListener(){
                hideFragment()
            }
            tvLogin.setOnClickListener(){
                Log.d("@", "onCreate: home touch")
                setStartDestination(R.id.loginFragment)
            }
            tvContactus.setOnClickListener(){
                Log.d("@", "onCreate: home touch")
                setStartDestination(R.id.feedbackFragment)
            }
        }

    }

    fun moveFragment() {
        Log.d("@", "moveFragment: moved")
        var animator = ObjectAnimator.ofFloat(binding.fragmentContainer1, "translationX", 800f)
        animator.interpolator = OvershootInterpolator()
        var rot = ObjectAnimator.ofFloat(binding.fragmentContainer1, View.ROTATION, -12f)
        animator.duration = 800
        rot.duration = 800
        rot.start()
        animator.start()
    }

    fun hideFragment() {
        Log.d("@", "moveFragment: hide")
        val rot = ObjectAnimator.ofFloat(binding.fragmentContainer1, View.ROTATION, 0f)
        val tra = ObjectAnimator.ofFloat(binding.fragmentContainer1, View.TRANSLATION_X, 0f)
        var animatory = ObjectAnimator.ofFloat(binding.fragmentContainer1, View.TRANSLATION_Y, 0f)
        binding.fragmentContainer1.isClickable = true
        // animator.repeatCount=1
        rot.duration = 800
        tra.duration = 800
        animatory.duration = 1000
        //animator.repeatMode=ObjectAnimator.REVERSE
        rot.start()
        tra.start()
        animatory.start()
    }

    private fun setStartDestination(id: Int) {
        val controller = binding.fragmentContainer1.findNavController()
        val graph = controller.navInflater.inflate(R.navigation.navgraph)
        graph.setStartDestination(id)
        controller.graph = graph
    }

}