package com.example.mentalmate_android__app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for the MainActivity
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.loginBtn)
        buttonClick.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_profile -> {
                    // Handle profile item click
                    true
                }
                R.id.navigation_insights -> {
                    // Handle AI insights item click
                    true
                }
                R.id.navigation_resources -> {
                    // Handle resources item click
                    true
                }
                R.id.navigation_health_sensors -> {
                    // Handle health sensors item click
                    true
                }
                R.id.navigation_emotional_intelligence -> {
                    // Handle emotional intelligence item click
                    true
                }
                R.id.navigation_support_network -> {
                    // Handle support network item click
                    true
                }
                else -> false
            }
        }
    }
}