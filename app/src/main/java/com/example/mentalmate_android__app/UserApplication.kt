package com.example.mentalmate_android__app

import android.app.Application

class UserApplication : Application(){
    val db by lazy{AppDatabase.getInstance(this)}
}