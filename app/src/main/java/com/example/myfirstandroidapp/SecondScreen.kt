package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val textNameStr: TextView = findViewById(R.id.textName)
        textNameStr.text = "Adam Mickiewicz"

        val imageButtonChevron: ImageButton = findViewById(R.id.imageButtonChevron)
        imageButtonChevron.setOnClickListener {
            openScreen1()
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            openRNG()
        }
    }

    private fun openScreen1() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun openRNG() {
        startActivity(Intent(this, RandomNumberGenerator::class.java))
    }
}