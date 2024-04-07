package com.example.mentalmate_android__app

data class InsightResponse(val id: String, val created: String, val choices: List<InsightChoice>)

data class InsightChoice(val text: String)
