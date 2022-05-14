package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val textNameStr: TextView = findViewById(R.id.textName)
        textNameStr.text = "Jan Twardowski"

        val textCounter: TextView = findViewById(R.id.textCounter)
        var textCounterInt = 0

        val rollButton: Button = findViewById(R.id.button)

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
            openScreen1()
        }

        val imageButtonExit: ImageButton = findViewById(R.id.imageButtonExit)
        imageButtonExit.setOnClickListener {
            exitProcess(0)
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView3)
        resultTextView.text = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun openScreen1() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}