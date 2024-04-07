package com.example.mentalmate_android__app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getInsights(prompt: String) = liveData(Dispatchers.IO) {
        val response = userRepository.getInsights(prompt)
        if (response.isSuccessful) {
            emit(response.body()?.choices?.first()?.text ?: "")
        } else {
            emit("Error: ${response.message()}")
        }
    }
}
