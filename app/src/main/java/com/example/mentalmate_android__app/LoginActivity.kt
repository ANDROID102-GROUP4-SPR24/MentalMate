package com.example.mentalmate_android__app

//import android.content.ContentValues.TAG
//import android.content.Context
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import kotlinx.coroutines.launch
//
//class LoginActivity : AppCompatActivity() {
//    private lateinit var database: LoginDatabase
//
//    fun showToast(context: Context, message: String) {
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        database = LoginDatabase.getDatabase(this)
//
//        val usernameEditText = findViewById<EditText>(R.id.enterUserName)
//        val passwordEditText = findViewById<EditText>(R.id.enterPassword)
//        val loginButton = findViewById<Button>(R.id.loginBtn)
//
//        loginButton.setOnClickListener {
//            val username = usernameEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            lifecycleScope.launch {
//                //val user = database.loginDao().getUser(username, password)
////                if (user != null) {
////                    // Successful
////                    Log.i(TAG, "Login success!")
//////                } else {
//////                    // Login failed
//////
//////                    //Toast.makeText( "Login failed", Toast.LENGTH_SHORT,this).show()
//////                }
//                if(username == "Brian"){
//                    showToast(this, "Welcome to Kotlin!")
//                }else{
//                    Toast("login fail")
//                }
//
//            }
//
//        }
//    }
//}



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

            if (username.isNotEmpty() && password.isNotEmpty()) {
                lifecycleScope.launch {
                    try {
                        val user = database.loginDao().getUser(username, password)
                        if (user != null) {
                            // Successful login
                            Log.i(TAG, "Login success!")
                        } else {
                            // Login failed
                            Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Error during login", e)
                        Toast.makeText(this@LoginActivity, "An error occurred during login", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this@LoginActivity, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}