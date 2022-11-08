package com.example.train_food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.train_food.R
import com.example.train_food.databinding.FeedbackTileBinding
import com.example.train_food.databinding.FoodCardBinding

class FeedbackAdapter(
    private val context: Context,
    var feedbackList: List<FeedbackModel>
) :RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder>() {
    var click: ((FeedbackModel) -> Unit)? = null
    var clickBack: ((FeedbackModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackAdapter.FeedbackViewHolder {

        val binding = FeedbackTileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedbackViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return feedbackList.size
    }

    override fun onBindViewHolder(holder: FeedbackAdapter.FeedbackViewHolder, position: Int) {
        holder.bind(feedbackList[position])
    }

    inner class FeedbackViewHolder(val binding:FeedbackTileBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(feedback:FeedbackModel) {
            binding.apply {
               tvPassengerName.text=feedback.userName
               tvFeedback.text=feedback.complaint
             //  tv.text=feedback.ratingValue

                /*val media=film.image
                Glide.with(this.cardImage).load(media).apply(RequestOptions.circleCropTransform()).into(cardImage)
*/
            }
            clickBack?.invoke(feedback)

            binding.root.setOnClickListener(){
                click?.invoke(feedbackList[adapterPosition])
            }
        }
    }
}