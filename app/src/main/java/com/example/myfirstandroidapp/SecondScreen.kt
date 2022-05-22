package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val userName = "Jan Kowalski"
        val textNameStr = findViewById<TextView>(R.id.s2welcomeText)
        textNameStr.text = getString(R.string.second_screen_text, userName)

        val appCounter = 1 // initial value
        val textAppCounter = findViewById<TextView>(R.id.s2counterText)
        textAppCounter.text = getString(R.string.counter_text, appCounter)


        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            Toast.makeText(this, "Function disabled! Try system back instead.", Toast.LENGTH_SHORT).show()
        }

        val buttonDice = findViewById<Button>(R.id.s2buttonDice)
        buttonDice.setOnClickListener {
            openRNG()
        }

        val buttonTip = findViewById<Button>(R.id.s2buttonTip)
        buttonTip.setOnClickListener {
            openTipCalculator()
        }
    }

    private fun openRNG() {
        startActivity(Intent(this, RandomNumberGenerator::class.java))
    }

    private fun openTipCalculator() {
        startActivity(Intent(this, TipCalculator::class.java))
    }
}