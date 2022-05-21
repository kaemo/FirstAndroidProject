package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TipCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_calculator)

        val imageButtonChevron: ImageButton = findViewById(R.id.imageButtonChevron)
        imageButtonChevron.setOnClickListener {
            openScreen2()
        }
    }

    private fun openScreen2() {
        finish()
        startActivity(Intent(this, SecondScreen::class.java))
    }
}