package com.example.menupager.adapters

import android.annotation.SuppressLint
import android.graphics.Color
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
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var selectedPosition = -1
    var onItemClickListener: OnItemClickListener? = null

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_shoes_revers, parent, false)
            ShoesViewHolder(itemView)
        } else {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_list_model, parent, false)
            ShoesReverseViewHolder(itemView)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var shoe = itemList[position]
        holder.apply {
            if (selectedPosition == position) {
                itemView.setBackgroundColor(Color.RED)
            } else {
                itemView.setBackgroundColor(Color.WHITE)
            }
            when (this) {
                is ShoesViewHolder -> {
                    name.text = shoe.name
                    price.text = shoe.price
                    Glide.with(itemView.context).load(shoe.image).into(image)
                    itemView.setOnClickListener {
                        selectedPosition = position
                        notifyDataSetChanged()
                        onItemClickListener?.onItemClick(shoe)
                    }
                }
                is ShoesReverseViewHolder -> {
                    nameReverse.text = shoe.name
                    priceReverse.text = shoe.price
                    Glide.with(itemView.context).load(shoe.image).into(imageReverse)
                    itemView.setOnClickListener {
                        selectedPosition = position
                        notifyDataSetChanged()
                        onItemClickListener?.onItemClick(shoe)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(shoes: Shoes)
    }

    inner class ShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: AppCompatTextView
        val price: AppCompatTextView
        val image: AppCompatImageView

        init {
            name = itemView.findViewById(R.id.tv_nameReverse)
            price = itemView.findViewById(R.id.tv_priceReverse)
            image = itemView.findViewById(R.id.iv_shoesReverse)
        }
    }

    inner class ShoesReverseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameReverse: AppCompatTextView
        val priceReverse: AppCompatTextView
        val imageReverse: AppCompatImageView

        init {
            nameReverse = itemView.findViewById(R.id.tv_nameReverse)
            priceReverse = itemView.findViewById(R.id.tv_priceReverse)
            imageReverse = itemView.findViewById(R.id.iv_shoesReverse)
        }
    }
}