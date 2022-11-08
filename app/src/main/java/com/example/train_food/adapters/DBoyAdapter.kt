package com.example.train_food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.train_food.R
import com.example.train_food.databinding.ProfileCardBinding
import com.example.train_food.databinding.TrainCardBinding

class DBoyAdapter(
    private val context: Context,
    private var DBoyList: List<DeliveryBoyModel>
) : RecyclerView.Adapter<DBoyAdapter.DBoyViewHolder>() {
    var click: ((DeliveryBoyModel) -> Unit)? = null
    var clickBack: ((DeliveryBoyModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DBoyViewHolder {

        val binding = ProfileCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DBoyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return DBoyList.size
    }

    override fun onBindViewHolder(holder: DBoyViewHolder, position: Int) {
        holder.bind(DBoyList[position])
    }

    inner class DBoyViewHolder(private val binding: ProfileCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(DBoy: DeliveryBoyModel) {
            binding.apply {
                tvBoyId.text = DBoy.boyId
                tvBoyName.text = DBoy.boyName
                tvBoyNumber.text = DBoy.mobile
                tvStopName.text = DBoy.stopName
                val media = DBoy.imageUrl
                val mediatest = R.drawable.delivery_man__1_
                Glide.with(this.ivBoy).load(mediatest).into(ivBoy)
            }
            clickBack?.invoke(DBoy)

            binding.root.setOnClickListener() {
                click?.invoke(DBoyList[adapterPosition])
            }
        }

    }
}
