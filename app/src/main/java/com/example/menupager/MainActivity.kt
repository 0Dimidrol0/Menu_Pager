package com.example.menupager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar?.hide()
        initView()
        setNavController()
    }

    private fun initView() {
        bottomNavView = findViewById(R.id.bottom_navigation)
    }

    private fun setNavController() {
        navController = Navigation.findNavController(this, R.id.container)
        bottomNavView.setupWithNavController(navController)
    }
}