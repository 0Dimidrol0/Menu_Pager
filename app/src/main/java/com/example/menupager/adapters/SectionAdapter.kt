package com.example.menupager.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle,
    var fragmentLIst: List<Fragment>
) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = fragmentLIst.size

    override fun createFragment(position: Int): Fragment = fragmentLIst[position]
}