package com.example.menupager.drawable_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.menupager.R
import com.example.menupager.databinding.FragmentItemBinding


class ItemFragment : Fragment() {
    private lateinit var binding: FragmentItemBinding
    private lateinit var image: AppCompatImageView
    private lateinit var name: AppCompatTextView
    private lateinit var price: AppCompatTextView
    private val args: ItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_item, container, false)
        binding = FragmentItemBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setView()
    }

    private fun initView() {
        image = binding.ivItemImage
        name = binding.tvItemName
        price = binding.tvItemPrice
    }

    @SuppressLint("CheckResult")
    private fun setView() {
        name.text = args.itemName
        price.text = args.itemPrice
        Glide.with(requireContext()).load(args.itemImageUrl).into(image)
    }
}