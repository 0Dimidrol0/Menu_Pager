package com.example.menupager.menu_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.menupager.R
import com.example.menupager.adapters.SectionAdapter
import com.example.menupager.databinding.FragmentCartBinding
import com.example.menupager.tab_fragments.CartTabOneFragment
import com.example.menupager.tab_fragments.CartTabThreeFragment
import com.example.menupager.tab_fragments.CartTabTwoFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CartFragment : Fragment(R.layout.fragment_cart) {
    private var cartFragmentList = ArrayList<Fragment>()
    private lateinit var pagerAdapter: SectionAdapter
    private lateinit var pager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var buttonBack: ImageButton
    private lateinit var binding: FragmentCartBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavController(view)
        initView()
        initListeners()
        setList()
        initPager()
        initTabLayout()
    }

    private fun setNavController(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun initListeners() {
        buttonBack.setOnClickListener {
            navController.navigate(R.id.action_cartFragment_to_homeFragment)
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.tab_title_Apparel)
                    tab.setIcon(R.drawable.ic_apparel)
                }
                1 -> {
                    tab.text = getString(R.string.tab_title_Beauty)
                    tab.setIcon(R.drawable.ic_beauty)
                }
                2 -> {
                    tab.text = getString(R.string.tab_title_Shoes)
                    tab.setIcon(R.drawable.ic_shoes)
                }
            }
        }.attach()
    }

    private fun initPager() {
        pagerAdapter = SectionAdapter(childFragmentManager, lifecycle, cartFragmentList)
        pager.adapter = pagerAdapter
    }

    private fun setList() {
        cartFragmentList.add(CartTabOneFragment())
        cartFragmentList.add(CartTabTwoFragment())
        cartFragmentList.add(CartTabThreeFragment())
    }

    private fun initView() {
        pager = requireView().findViewById(R.id.view_pager)
        tabLayout = requireView().findViewById(R.id.tl_cart)
        buttonBack = requireView().findViewById(R.id.btn_back)
    }
}