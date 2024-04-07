package com.example.mentalmate_android__app

class UserRepository(private val apiService: ApiService) {
    suspend fun getInsights(prompt: String) = apiService.getInsights(prompt)
}
// Compare this snippet from app/src/main/java/com/example/mentalmate_android__app/UserViewModelFactory.kt: