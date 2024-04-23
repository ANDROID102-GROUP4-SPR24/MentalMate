package com.example.mentalmate_android__app

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var database: LoginDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        database = LoginDatabase.getDatabase(this)

        val usernameEditText = findViewById<EditText>(R.id.enterUserName)
        val passwordEditText = findViewById<EditText>(R.id.enterPassword)
        val loginButton = findViewById<Button>(R.id.loginBtn)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            lifecycleScope.launch {
                val user = database.loginDao().getUser(username, password)
                if (user != null) {
                    // Successful
                    Log.i(TAG, "Login success!")
                } else {
                    // Login failed

                    //Toast.makeText( "Login failed", Toast.LENGTH_SHORT,this).show()
                }
            }
        }
    }
}


