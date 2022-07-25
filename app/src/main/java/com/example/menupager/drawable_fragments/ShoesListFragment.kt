package com.example.menupager.drawable_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menupager.R
import com.example.menupager.Res.Images
import com.example.menupager.Res.Shoes
import com.example.menupager.adapters.ShoesAdapter
import com.example.menupager.databinding.FragmentShoesListBinding


class ShoesListFragment : Fragment(), ShoesAdapter.OnItemClickListener {

    private lateinit var binding: FragmentShoesListBinding
    private lateinit var shoesRecyclerView: RecyclerView
    private lateinit var shoesAdapter: ShoesAdapter
    private var shoesList = arrayListOf<Shoes>()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shoes_list, container, false)
        binding = FragmentShoesListBinding.bind(view)
        setNavController()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setRecycleView()
    }

    override fun onItemClick(shoes: Shoes) {
        navController.navigate(navigateToItemFragment(shoes))
    }

    private fun setNavController() {
        navController = findNavController()
    }

    private fun setRecycleView() {
        setShoesLIst()
        shoesAdapter = ShoesAdapter(shoesList)
        shoesAdapter.setListener(this)
        shoesRecyclerView.adapter = shoesAdapter
        shoesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        val helper : SnapHelper = LinearSnapHelper()
//        helper.attachToRecyclerView(shoesRecyclerView)

    }

    private fun setShoesLIst() {
        shoesList.add(Shoes("Adidas", 0, "150", Images.ADIDAS.image))
        shoesList.add(Shoes("Adidas", 1, "250", Images.ADIDAS3.image))
        shoesList.add(Shoes("Adidas", 1, "125", Images.ADIDAS2.image))
        shoesList.add(Shoes("Nike", 0, "143", Images.NIKE4.image))
        shoesList.add(Shoes("Nike", 0, "193", Images.NIKE3.image))
        shoesList.add(Shoes("Nike", 1, "263", Images.NIKE2.image))
        shoesList.add(Shoes("Nike", 0, "988", Images.NIKE.image))
        shoesList.add(Shoes("ReeBok", 1, "111", Images.REEBOK.image))
        shoesList.add(Shoes("ReeBok", 1, "456", Images.REEBOK2.image))
        shoesList.add(Shoes("ReeBok", 1, "667", Images.REEBOK4.image))
    }

    private fun initView() {
        shoesRecyclerView = binding.ShoesRecycleView

    }

    private fun navigateToItemFragment(ShoesItem: Shoes): NavDirections {
        return ShoesListFragmentDirections.actionShoesListToItemFragment(
            ShoesItem.name,
            ShoesItem.price,
            ShoesItem.image
        )
    }
}