package com.example.train_food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.train_food.databinding.OrderCardBinding
import com.example.train_food.databinding.TrainCardBinding

class OrderAdapter(
    private val context: Context,
    private var orderList: List<OrderModel>
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    var click: ((OrderModel) -> Unit)? = null
    var clickBack: ((OrderModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        val binding = OrderCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orderList[position])
    }

    inner class OrderViewHolder(private val binding: OrderCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order: OrderModel) {
            binding.apply {
               tvFoodPrice.text=order.price
               //tvFoodname.text=order.
               tvQuantity.text= order.quantity.toString()
               tvUsername.text=order.userName
               tvUserPhone.text=order.userPhone
                //var path:String="${train.startPoint} - ${train.endPoint}"
                //tvTrainPath.text=path

                /*val media=film.image
                Glide.with(this.cardImage).load(media).apply(RequestOptions.circleCropTransform()).into(cardImage)
*/
            }
            clickBack?.invoke(order)

            binding.root.setOnClickListener(){
                click?.invoke(orderList[adapterPosition])
            }
        }

    }
}