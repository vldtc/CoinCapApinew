package com.example.coincapapi

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coincapapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //dda969ef-28be-4d6c-bd4c-6b6cd5cc2290 <- CoinCap Access Token

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_assets,
                R.id.navigation_rates,
                R.id.navigation_home,
                R.id.navigation_exchanges,
                R.id.navigation_markets
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_assets -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_exchanges -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_markets -> {
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_rates -> {
                    navView.visibility = View.VISIBLE
                }
                else -> {
                    navView.visibility = View.GONE
                }
            }
//            if(navController.currentDestination?.id == R.layout.fragment_exchange_details) {
//                navView.visibility = View.GONE
//            } else {
//                navView.visibility = View.VISIBLE
//            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
