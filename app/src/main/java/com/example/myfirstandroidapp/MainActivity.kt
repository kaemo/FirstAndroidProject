package com.example.myfirstandroidapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        if (checkboxStatus.isChecked) {
            val editor = sharedPref.edit()
            editor.putInt("COUNTER", 0)
            editor.apply()
        }

        Intent(this, SecondScreen::class.java).also {
            it.putExtra("extraUserInput", userNameFieldText)
            it.putExtra("extraCheckboxStatus", checkboxStatus.isChecked.toString())
            it.putExtra("extraSPStatus", sharedPref.getInt("COUNTER", -1))

            startActivity(it)
        }
    }

    private fun countAndSave() {

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        var launchCounter = sharedPref.getInt("COUNTER", 0)

        launchCounter++

        val editor = sharedPref.edit()

        editor.putInt("COUNTER", launchCounter)
        editor.apply()
    }
}