package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class RandomNumberGenerator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number_generator)
        val rollButton: Button = findViewById(R.id.button)

        val textCounter: TextView = findViewById(R.id.textCounter)
        var textCounterInt = 0

        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            rollDice()

            // single line code second dice without pictures
            findViewById<TextView>(R.id.secondCounter).text = (1..6).random().toString()

            textCounterInt++ //textCounterInt += 1
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

        val imageDice: ImageView = findViewById(R.id.imageViewDice)
        imageDice.setImageResource(when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> {
                Log.i("imageDiceTag", "Lucky number has been drawn")
                R.drawable.dice_6
            }
            else -> {
                Log.w("imageDiceTag", "Number out of the range. Wrong picture was displayed.")
                R.drawable.ic_launcher_background
            }
        })
        imageDice.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return Random(System.currentTimeMillis()).nextInt(1, numSides+1)
        }
    }

    private fun openScreen2() {
        finish()
        startActivity(Intent(this, SecondScreen::class.java))
    }
}