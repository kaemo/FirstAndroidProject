package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            openSecondScreen()
        }

        val imageButtonExit: ImageButton = findViewById(R.id.imageButtonExit)
        imageButtonExit.setOnClickListener {
            finishAffinity()
        }
    }

    private fun openSecondScreen() {
        startActivity(Intent(this, SecondScreen::class.java))
    }

}