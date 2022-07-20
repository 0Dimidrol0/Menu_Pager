package com.example.menupager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_UNLOCKED
import androidx.navigation.NavController
import androidx.navigation.Navigation
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
    private lateinit var navController: NavController
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
        setNavControllerForBottomNav()
        setAppBarConfig()
        setupActionBarWithNavController(navController, appBarConfiguration)
        initListeners()
    }

    private fun initListeners() {
        initNavDrawerListener()
    }

    private fun initNavDrawerListener() {
        navDrawerView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.my_networks -> Toast.makeText(this, "Networks!", Toast.LENGTH_SHORT).show()
                R.id.wifi_on_map -> Toast.makeText(this, "MAP!", Toast.LENGTH_SHORT).show()
                R.id.data_usage -> Toast.makeText(this, "75%!", Toast.LENGTH_SHORT).show()
                R.id.add_network -> Toast.makeText(
                    this,
                    "No available new Network!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun initView() {
        bottomNavView = binding.bottomNavigation
        drawerLayout = binding.MainRoot
        navDrawerView = binding.navView
    }

    private fun setNavControllerForBottomNav() {
        navController = Navigation.findNavController(this, R.id.container)
        bottomNavView.setupWithNavController(navController)
    }

    private fun setAppBarConfig() {
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment
            ), drawerLayout
        )
    }

    private fun navDrawerLocker(): DrawerLayout {
        if (navController.currentDestination?.id == R.id.cartFragment) {
            drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
        } else {
            drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED)
        }
        return drawerLayout
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}