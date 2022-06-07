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

        val userName = intent.getStringExtra(SEC_USER_NAME)
        val textNameStr = findViewById<TextView>(R.id.s2welcomeText)
        textNameStr.text = getString(R.string.second_screen_text, userName)

        val appLaunchCounter = intent.getIntExtra(SEC_COUNTER, -2)
        val textAppCounter = findViewById<TextView>(R.id.s2counterText)

        if (appLaunchCounter == 1){
            textAppCounter.text = getString(R.string.constant_counter_text)
        } else {
            textAppCounter.text = getString(R.string.counter_text, appLaunchCounter)
        }

        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            onBackPressed()
        }

        val buttonDice = findViewById<Button>(R.id.s2buttonDice)
        buttonDice.setOnClickListener {
            openRNG()
        }

        val buttonTip = findViewById<Button>(R.id.s2buttonTip)
        buttonTip.setOnClickListener {
            openTipCalculator()
        }

        findViewById<Button>(R.id.s2buttonANC).setOnClickListener {
            startActivity(Intent(this, NumberConverter::class.java))
        }
    }

    private fun openRNG() {
        startActivity(Intent(this, RandomNumberGenerator::class.java))
    }

    private fun openTipCalculator() {
        startActivity(Intent(this, TipCalculator::class.java))
    }
}