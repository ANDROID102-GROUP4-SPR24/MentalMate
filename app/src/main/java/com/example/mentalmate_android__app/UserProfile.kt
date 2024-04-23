package com.example.mentalmate_android__app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [UserProfile.newInstance] factory method to
 * create an instance of this fragment.
 */
//class UserProfile : Fragment() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        //return inflater.inflate(R.layout.fragment_user_profile, container, false)
//        return inflater.inflate(R.layout.user_detail, container, false)
//    }
//
//}

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.*

class UserProfile : Fragment() {
    private var db: AppDatabase? = null
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.user_detail, container, false)
        val nameEditText = view.findViewById<EditText>(R.id.userNameET)
        val ageEditText=view.findViewById<EditText>(R.id.userAgeET)
        val sexEditText = view.findViewById<EditText>(R.id.userSexET)
        val mentalHealthEditText = view.findViewById<EditText>(R.id.userMentalHealthET);
        val goalsEditText = view.findViewById<EditText>(R.id.userGoalsET);

        val saveButton = view.findViewById<Button>(R.id.saveButton)

        db = (activity?.application as UserApplication).db

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val ageString = ageEditText.text.toString()
            val age: Int = ageString.toInt()
            val sex = sexEditText.text.toString()
            val mentalHealth=mentalHealthEditText.text.toString()
            val goals = goalsEditText.text.toString()

            val userProfile = UserProfileEntity(name = name, age = age, sex = sex, mentalHealth = mentalHealth, goals=goals)

            coroutineScope.launch {
                saveUserProfile(userProfile)
                nameEditText.setText(name)// Update UI directly
                ageEditText.setText(ageString)
                sexEditText.setText(sex)
                mentalHealthEditText.setText(mentalHealth)
                goalsEditText.setText(goals)

                nameEditText.clearFocus()
                ageEditText.clearFocus()
                sexEditText.clearFocus()
                mentalHealthEditText.clearFocus()
                goalsEditText.clearFocus()

                loadAndPrintAllProfiles()
            }
        }

        return view
    }

    private suspend fun saveUserProfile(profile: UserProfileEntity) {
        withContext(Dispatchers.IO) {
            db?.UserProfileDao()?.insert(profile)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel() // Cancel coroutines when the Fragment is destroyed to avoid leaks
    }

    private suspend fun loadAndPrintAllProfiles() {
        withContext(Dispatchers.IO) {
            val profiles = db?.UserProfileDao()?.getAllProfiles()
            withContext(Dispatchers.Main) {
                profiles?.forEach { profile ->
                    Log.d("UserProfileLog", "Profile: ${profile.name}, Age: ${profile.age}, Sex: ${profile.sex}, Mental Health: ${profile.mentalHealth}, Goals: ${profile.goals}")
                }
            }
        }
    }
}
