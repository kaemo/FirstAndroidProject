package com.example.myfirstandroidapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TipCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_calculator)

        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            Toast.makeText(this, "Function disabled! Try system back instead.", Toast.LENGTH_SHORT).show()
        }
    }
}