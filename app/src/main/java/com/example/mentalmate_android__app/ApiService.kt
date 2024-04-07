package com.example.mentalmate_android__app

import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface ApiService {
    @GET("generate")
    suspend fun getInsights(@Query("prompt") prompt: String): Response<InsightResponse>
}
