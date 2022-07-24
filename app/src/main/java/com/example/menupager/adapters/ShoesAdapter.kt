package com.example.menupager.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.menupager.R
import com.example.menupager.Res.Shoes

class ShoesAdapter(
    var itemList: ArrayList<Shoes>,
) : RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>() {

    class ShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: AppCompatTextView
        val price: AppCompatTextView
        val image: AppCompatImageView
        private var isClicked: Boolean

        init {
            name = itemView.findViewById(R.id.tv_name)
            price = itemView.findViewById(R.id.tv_price)
            image = itemView.findViewById(R.id.iv_shoes)
            isClicked = false
            itemView.setOnClickListener {
                if (isClicked) {
                    isClicked = false
                    itemView.setBackgroundColor(itemView.context.resources.getColor(R.color.white))
                } else {
                    isClicked = true
                    itemView.setBackgroundColor(itemView.context.resources.getColor(R.color.yellow))
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_model, parent, false)
        return ShoesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        holder.apply {
            name.text = itemList[position].name
            price.text = itemList[position].price
            Glide.with(itemView.context).load(itemList[position].image).into(image)
        }
    }

    override fun getItemCount(): Int = itemList.size

}