package com.example.menupager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.menupager.menu_fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListeners()
        setFragmentToContainer(HomeFragment())
    }


    private fun initView(){
        bottomNavView = findViewById(R.id.bottom_navigation)
    }

    private fun initListeners(){
        bottomNavView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.btn_home -> setFragmentToContainer(HomeFragment())
                R.id.btn_cart -> setFragmentToContainer(CartFragment())
                R.id.btn_search -> setFragmentToContainer(SearchFragment())
                R.id.btn_more -> setFragmentToContainer(MoreFragment())
                R.id.btn_profile -> setFragmentToContainer(ProfileFragment())
                else -> setFragmentToContainer(HomeFragment())
            }
        }
    }

    private fun setFragmentToContainer(fragment: Fragment):Boolean {
        if (supportFragmentManager.fragments.contains(fragment)) {
            supportFragmentManager.beginTransaction().attach(fragment)
        } else {
            supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
        }
        return true
    }
}