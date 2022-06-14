package com.example.myfirstandroidapp

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

class NumberConverter : AppCompatActivity() {

    var input = ""
    var format = FormatType.RAW
//    var validNumberFlag: Boolean = false    //martwy kod ale pytanko: 1. lateinit dla Booleana? 2. tab vs spacje

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_converter)

        // navbar

        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            onBackPressed()
        }

        // rest of the screen

        val userInputField = findViewById<EditText>(R.id.userAccNum)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val showNumber = findViewById<TextView>(R.id.textViewPresentNumber)
        val showValidation = findViewById<TextView>(R.id.textViewValidation)

        radioGroup.check(R.id.radioButtonRaw)   //domyślne zaznaczenie jednego z radiobuttonów

        radioGroup.setOnCheckedChangeListener { _, id ->                        //jeszcze raz bym potrzebował wytłumaczenia o co z tym parametrem 'group' chodziło i w sumie dlaczego możemy go w tym momencie pominąć - i kiedy byśmy niemogli poinąć
            format = resolveFormatTypeById(id)
            Log.d("TEST", "Format type: $format")
            showNumber.text = input.formatAccountNumberOrRaw(format)
            showValidation.text = checkIfCorrectAccountNumber(input)
        }

        userInputField.doOnTextChanged { text, _, _, _ ->
            showValidation.text = ""
            input = text.toString()
            showNumber.text = input.formatAccountNumberOrRaw(format)
        }



    }

    private fun checkIfCorrectAccountNumber(number: String): String{
        return if (number.length != 26) {
            "Invalid account number!"
        } else {
            ""
        }
    }

    private fun resolveFormatTypeById(id: Int): FormatType {
        return when (id) {
            R.id.radioButtonFormatted -> FormatType.FORMATTED
            R.id.radioButtonMasked -> FormatType.MASKED
            else -> FormatType.RAW
        }
    }

    private fun String.formatAccountNumberOrRaw(format: FormatType): String {
        return if (this.length != 26) {
            this
        } else {
            when (format) {
                FormatType.RAW -> this
                FormatType.FORMATTED -> formatted(this)
                FormatType.MASKED -> masked(this)
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

        return "$str1 ... $str2"
    }
}

enum class FormatType {
    RAW,
    FORMATTED,
    MASKED
}