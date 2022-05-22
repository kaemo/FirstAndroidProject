package com.example.myfirstandroidapp

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

        Intent(this, SecondScreen::class.java).also {
            it.putExtra("extraUserInput", userNameFieldText)
            it.putExtra("extraCheckboxStatus", checkboxStatus.isChecked.toString())

            startActivity(it)
        }
    }

}