package com.example.myfirstandroidapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstandroidapp.NavigationManager.navigateToSecondScreen

class MainActivity : AppCompatActivity() {
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPrefs = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) //taka sama linijka pojawia się 3 razy w kodzie - czy da się tego uniknąć?

        countAndSave()

        findViewById<ImageButton>(R.id.s1imageButtonExit).setOnClickListener {
            finishAffinity()
        }

        findViewById<Button>(R.id.s1buttonNext).setOnClickListener {
            openSecondScreen()
        }
    }

    private fun openSecondScreen() {
        val userNameField = findViewById<EditText>(R.id.s1personNameString)
        val userNameFieldText = userNameField.text.toString()

        val checkboxStatus = findViewById<CheckBox>(R.id.s1checkBox)

        sharedPrefs = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

        if (checkboxStatus.isChecked) {
            val editor = sharedPrefs.edit()
            editor.putInt(SHARED_PREF_COUNTER_KEY, 0)
            editor.apply()
        }
        navigateToSecondScreen(userNameFieldText, sharedPrefs.getInt(SHARED_PREF_COUNTER_KEY, -1))
    }

    private fun countAndSave() {

        sharedPrefs = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

        var launchCounter = sharedPrefs.getInt(SHARED_PREF_COUNTER_KEY, 0)

        launchCounter++

        val editor = sharedPrefs.edit()

        editor.putInt(SHARED_PREF_COUNTER_KEY, launchCounter)
        editor.apply()
    }

    companion object {
        const val SHARED_PREFS_KEY = "KMApp_Shared_prefs"
        const val SHARED_PREF_COUNTER_KEY = "COUNTER"
    }
}