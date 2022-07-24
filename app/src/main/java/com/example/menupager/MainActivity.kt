package com.example.menupager

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.menupager.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var defaultNavController: NavController
//    private lateinit var drawerNavController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawerView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val actionBar = supportActionBar
//        actionBar?.hide()

        initView()
        setAppBarConfig()
        setupNavControllers()
//        initListeners()
    }

    private fun initListeners() {
        initNavDrawerListener()
    }

    private fun initNavDrawerListener() {
//        navDrawerView.setNavigationItemSelectedListener {
//            defaultNavController.navigate(R.id.drawer_container)
//             when (it.itemId) {
//                R.id.my_networks -> defaultNavController.navigate(R.id.my_networks)
//                R.id.wifi_on_map -> defaultNavController.navigate(R.id.wifi_on_map)
//                R.id.data_usage -> defaultNavController.navigate(R.id.data_usage)
//                R.id.add_network -> defaultNavController.navigate(R.id.add_network)
//            }
//            drawerLayout.closeDrawer(GravityCompat.START)
//            true
//        }
    }

    private fun initView() {
        bottomNavView = binding.bottomNavigation
        drawerLayout = binding.MainRoot
        navDrawerView = binding.navView
    }

    private fun setupNavControllers() {
        defaultNavController = Navigation.findNavController(this, R.id.container)
        bottomNavView.setupWithNavController(defaultNavController)
        navDrawerView.setupWithNavController(defaultNavController)
        setupActionBarWithNavController(defaultNavController, appBarConfiguration)
    }

    private fun setAppBarConfig() {
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment
            ), drawerLayout
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return defaultNavController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun setNavigation(navController:NavController,@NavigationRes Graph : Int):NavGraph =
        navController.navInflater.inflate(Graph)
}