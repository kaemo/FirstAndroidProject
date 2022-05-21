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

        val userName = "Jan Kowalski"
        val textNameStr: TextView = findViewById(R.id.secondScreenWelcomeText)
        textNameStr.text = getString(R.string.second_screen_text, userName)

        val appCounter = 1 // initial value
        val textAppCounter: TextView = findViewById(R.id.counterTextID)
        textAppCounter.text = getString(R.string.counter_text, appCounter)


        val imageButtonChevron: ImageButton = findViewById(R.id.imageButtonChevron)
        imageButtonChevron.setOnClickListener {
            openScreen1()
        }

        val buttonDice: Button = findViewById(R.id.s2buttonDice)
        buttonDice.setOnClickListener {
            openRNG()
        }

        val buttonTip: Button = findViewById(R.id.s2buttonTip)
        buttonTip.setOnClickListener {
            openTipCalculator()
        }
    }

    private fun openScreen1() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun openRNG() {
        finish()
        startActivity(Intent(this, RandomNumberGenerator::class.java))
    }

    private fun openTipCalculator() {
        finish()
        startActivity(Intent(this, TipCalculator::class.java))
    }
}