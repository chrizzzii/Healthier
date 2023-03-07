package com.example.healthier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.healthier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setUpTabBar()
    }

    private fun setUpTabBar() {
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it) {
                R.id.nav_home -> binding.textMain.text = "Home"
                R.id.nav_chat -> binding.textMain.text = "Chat"
                R.id.nav_person -> {
                    binding.textMain.text = "Profile"
                    binding.bottomNavBar.showBadge(R.id.nav_settings)
                }
                R.id.nav_settings -> {
                    binding.textMain.text = "Settings"
                    binding.bottomNavBar.dismissBadge(R.id.nav_settings)
                }

            }
        }
    }
}