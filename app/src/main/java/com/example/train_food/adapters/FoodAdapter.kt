package com.example.train_food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.train_food.R
import com.example.train_food.databinding.FoodCardBinding

class FoodAdapter(
    private val context: Context,
    private var foodList: List<FoodModel>
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    var click: ((FoodModel) -> Unit)? = null
    var clickBack: ((FoodModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {

        val binding = FoodCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    inner class FoodViewHolder(private val binding:FoodCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: FoodModel) {
            binding.apply {
               tvFoodName.text=food.name
               tvFoodPrice.text=food.price

                val media = R.drawable.healthy_drink
                Glide.with(this.ivImage).load(media).into(ivImage)

                /*val media=film.image
                Glide.with(this.cardImage).load(media).apply(RequestOptions.circleCropTransform()).into(cardImage)
*/
            }
            clickBack?.invoke(food)

            binding.root.setOnClickListener(){
                click?.invoke(foodList[adapterPosition])
            }
        }

    }


}