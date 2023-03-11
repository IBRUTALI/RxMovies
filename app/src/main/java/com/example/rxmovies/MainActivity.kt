package com.example.rxmovies

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.rxmovies.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }
    private fun setupNavigation() {
        navController = Navigation.findNavController(this, R.id.nav_host)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment
            )
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.toolbar.inflateMenu(R.menu.main_menu)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.splashFragment) {
                binding.toolbar.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.mainFragment) {
            finish()
        } else {
            navController.popBackStack()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return if (binding.root.findNavController().currentDestination?.id != R.id.mainFragment)
            navController.navigateUp() || onSupportNavigateUp()
        else false
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}