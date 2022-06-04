package com.example.myfirstandroidapp

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TipCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_calculator)

        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            onBackPressed()
        }
    }
}