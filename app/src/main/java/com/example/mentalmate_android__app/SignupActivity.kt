package com.example.mentalmate_android__app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {
    private lateinit var database: LoginDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        database = LoginDatabase.getDatabase(this)

        val usernameEditText = findViewById<EditText>(R.id.editTextNewUsername)
        val passwordEditText = findViewById<EditText>(R.id.editTextNewPassword)
        val signupButton = findViewById<Button>(R.id.buttonSignUp)

        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            lifecycleScope.launch {
                database.loginDao().insertUser(User(username = username, password = password))
                // Confirm registration and navigate or show message
            }
        }
    }
}
