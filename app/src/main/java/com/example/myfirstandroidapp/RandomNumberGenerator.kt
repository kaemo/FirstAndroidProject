package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RandomNumberGenerator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number_generator)
        val rollButton: Button = findViewById(R.id.button)

        val textCounter: TextView = findViewById(R.id.textCounter)
        var textCounterInt = 0

        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            //val resultTextView: TextView = findViewById(R.id.textView3)
            //resultTextView.text = (1..6).random().toString()

            rollDice()

            textCounterInt += 1
            textCounter.text = textCounterInt.toString()
        }

        val imageButtonChevron: ImageButton = findViewById(R.id.imageButtonChevron)
        imageButtonChevron.setOnClickListener {
            openScreen2()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textViewNumber)
        resultTextView.text = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun openScreen2() {
        finish()
        startActivity(Intent(this, SecondScreen::class.java))
    }
}