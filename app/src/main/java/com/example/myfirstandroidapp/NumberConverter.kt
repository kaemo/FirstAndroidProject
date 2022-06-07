package com.example.myfirstandroidapp

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NumberConverter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_converter)

        // navbar

        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            onBackPressed()
        }

        // rest of the screen

        val userInputField = findViewById<EditText>(R.id.userAccNum)
        val showNumber = findViewById<TextView>(R.id.textViewPresentNumber)

        val radioRaw = findViewById<RadioButton>(R.id.radioButtonRaw)
        val radioFormatted = findViewById<RadioButton>(R.id.radioButtonFormatted)
        val radioMasked = findViewById<RadioButton>(R.id.radioButtonMasked)

        radioRaw.setOnClickListener {
            val convToTxt = userInputField.text.toString()
            showNumber.text = convToTxt.formatAccountNumberOrRaw()
        }

        radioFormatted.setOnClickListener {
            val convToTxt = userInputField.text.toString()
            showNumber.text = convToTxt.formatAccountNumberOrRaw("format")
        }

        radioMasked.setOnClickListener {
            val convToTxt = userInputField.text.toString()
            showNumber.text = convToTxt.formatAccountNumberOrRaw("mask")
        }
    }


    private fun String.formatAccountNumberOrRaw(masked: String = "raw"): String { //nie do końca wiedziałem jak ta funkcja dzialała więc ją zmodyfikowałem na swoją
        return if (this.length != 26) {
            "Invalid account number!"
        } else {
            when (masked) {
                "raw" -> this
                "format" -> formatted(this)
                "mask" -> masked(this)
                else -> "unknown operation"
            }
        }
    }

    private fun formatted(rawNumber: String): String {

        var formattedNumber = rawNumber.replaceRange(2, 2, " ")
        formattedNumber = formattedNumber.replaceRange(7, 7, " ")
        formattedNumber = formattedNumber.replaceRange(12, 12, " ")
        formattedNumber = formattedNumber.replaceRange(17, 17, " ")
        formattedNumber = formattedNumber.replaceRange(22, 22, " ")
        formattedNumber = formattedNumber.replaceRange(27, 27, " ")

        return formattedNumber
    }

    private fun masked(rawNumber: String): String {

        val str1 = rawNumber.dropLast(20).replaceRange(2, 2, " ")
        val str2 = rawNumber.drop(22)

        return str1 + " ... " + str2
    }


}