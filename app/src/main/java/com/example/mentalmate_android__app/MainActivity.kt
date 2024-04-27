package com.example.mentalmate_android__app

//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import com.google.android.material.bottomnavigation.BottomNavigationView

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        val fragmentManager: FragmentManager = supportFragmentManager
//        val userInputFragment: Fragment =UserProfile()
//        val bottomNavigationView: BottomNavigationView =findViewById(R.id.bottom_navigation)
//        bottomNavigationView.setOnItemSelectedListener{ item ->
//            lateinit var fragment:Fragment
//            when(item.itemId){
//                R.id.navigation_profile -> fragment=userInputFragment
//                //add the other screens that the user can move to
//            }
//            fragmentManager.beginTransaction().replace(R.id.place_holder_frame,fragment).commit()
//            true
//        }
//        bottomNavigationView.selectedItemId= R.id.navigation_profile
//    }
//}

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for the MainActivity
        setContentView(R.layout.activity_login)


        val buttonClick = findViewById<Button>(R.id.loginBtn)
        buttonClick.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }
        // Initialize UI components and set up listeners
        //setupUI()
    }

//    private fun setupUI() {
//        // Example of setting up a button click listener
//        val buttonLogin = findViewById<Button>(R.id.loginBtn)
//        buttonLogin.setOnClickListener {
//            // Intent to open LoginActivity
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//
//        val buttonSignUp = findViewById<Button>(R.id.Signupbtn)
//        buttonSignUp.setOnClickListener {
//            // Intent to open SignupActivity
//            val intent = Intent(this, SignupActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
