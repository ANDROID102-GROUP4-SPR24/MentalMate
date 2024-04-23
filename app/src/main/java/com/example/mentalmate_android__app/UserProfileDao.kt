package com.example.mentalmate_android__app

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserProfileDao {
@Insert
fun insert(userProfile: UserProfileEntity)

@Query("SELECT * FROM user_profile_table WHERE id = :userId")
fun getUserProfile(userId: Long): UserProfileEntity

@Query("SELECT * FROM user_profile_table")
fun getAllProfiles(): List<UserProfileEntity>
}
