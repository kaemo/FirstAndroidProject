package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.s1imageButtonExit).setOnClickListener {
            finishAffinity()
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            val userNameField = findViewById<EditText>(R.id.s1personNameString)
            val textNameStr = findViewById<TextView>(R.id.textView3)
            textNameStr.text = userNameField.text.toString()
        }

        findViewById<Button>(R.id.s1buttonNext).setOnClickListener {
            openSecondScreen()
        }
    }

    private fun openSecondScreen() {
        startActivity(Intent(this, SecondScreen::class.java))
    }

}