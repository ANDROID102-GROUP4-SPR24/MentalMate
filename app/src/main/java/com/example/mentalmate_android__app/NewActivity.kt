package com.example.mentalmate_android__app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fragmentManager: FragmentManager = supportFragmentManager
        val userInputFragment: Fragment =UserProfile()
        val bottomNavigationView: BottomNavigationView =findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener{ item ->
            lateinit var fragment:Fragment
            when(item.itemId){
                R.id.navigation_profile -> fragment=userInputFragment
                //add the other screens that the user can move to
            }
            fragmentManager.beginTransaction().replace(R.id.place_holder_frame,fragment).commit()
            true
        }
        bottomNavigationView.selectedItemId= R.id.navigation_profile
    }
}