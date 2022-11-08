package com.example.train_food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.train_food.R
import com.example.train_food.databinding.FoodCardBinding
import com.example.train_food.databinding.TrainCardBinding

class TrainAdapter(
    private val context: Context,
    private var trainList: List<TrainModel>
) : RecyclerView.Adapter<TrainAdapter.TrainViewHolder>() {
    var click: ((TrainModel) -> Unit)? = null
    var clickBack: ((TrainModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {

        val binding = TrainCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return trainList.size
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        holder.bind(trainList[position])
    }

    inner class TrainViewHolder(private val binding: TrainCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(train: TrainModel) {
            binding.apply {
                tvTrainNumber.text=train.number
                tvTrainName.text=train.name
                var path:String="${train.startPoint} - ${train.endPoint}"
                tvTrainPath.text=path

                /*val media=film.image
                Glide.with(this.cardImage).load(media).apply(RequestOptions.circleCropTransform()).into(cardImage)
*/
            }
            clickBack?.invoke(train)

            binding.root.setOnClickListener(){
                click?.invoke(trainList[adapterPosition])
            }
        }

    }


}