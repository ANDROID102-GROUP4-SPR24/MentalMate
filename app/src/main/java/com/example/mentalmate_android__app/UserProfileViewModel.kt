package com.example.mentalmate_android__app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class UserProfileViewModel(private val userProfileDao: UserProfileDao) : ViewModel() {

    private val _userProfile = MutableLiveData<UserProfileEntity>()
    val userProfile: LiveData<UserProfileEntity> get() = _userProfile

    fun saveUserProfile(profile: UserProfileEntity) {
        viewModelScope.launch {
            userProfileDao.insert(profile)
            _userProfile.postValue(profile)  // Update LiveData which will trigger UI update
        }
    }

    fun getUserProfile(id: Long) {
        viewModelScope.launch {
            val profile = userProfileDao.getUserProfile(id)
            _userProfile.postValue(profile)
        }
    }
}
