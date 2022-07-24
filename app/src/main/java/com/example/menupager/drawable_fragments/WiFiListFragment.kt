package com.example.menupager.drawable_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menupager.R
import com.example.menupager.Res.Images
import com.example.menupager.Res.Shoes
import com.example.menupager.adapters.ShoesAdapter
import com.example.menupager.databinding.FragmentWiFiListBinding


class WiFiListFragment : Fragment() {

    private lateinit var binding: FragmentWiFiListBinding
    private lateinit var shoesRecyclerView: RecyclerView
    private lateinit var shoesAdapter: ShoesAdapter
    private var shoesList = arrayListOf<Shoes>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_wi_fi_list, container, false)
        binding = FragmentWiFiListBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setRecycleView()
    }

    private fun setRecycleView() {
        setShoesLIst()
        shoesAdapter = ShoesAdapter(shoesList)
        shoesRecyclerView.adapter = shoesAdapter
        shoesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        val helper : SnapHelper = LinearSnapHelper()
//        helper.attachToRecyclerView(shoesRecyclerView)

    }

    private fun setShoesLIst() {
        shoesList.add(Shoes("Adidas", 150, Images.ADIDAS))
        shoesList.add(Shoes("Adidas", 250, Images.ADIDAS3))
        shoesList.add(Shoes("Adidas", 125, Images.ADIDAS2))
        shoesList.add(Shoes("Nike", 143, Images.NIKE4))
        shoesList.add(Shoes("Nike", 193, Images.NIKE3))
        shoesList.add(Shoes("Nike", 263, Images.NIKE2))
        shoesList.add(Shoes("Nike", 988, Images.NIKE))
        shoesList.add(Shoes("ReeBok", 111, Images.REEBOK))
        shoesList.add(Shoes("ReeBok", 456, Images.REEBOK2))
        shoesList.add(Shoes("ReeBok", 667, Images.REEBOK4))
    }

    private fun initView() {
        shoesRecyclerView = binding.ShoesRecycleView
    }
}