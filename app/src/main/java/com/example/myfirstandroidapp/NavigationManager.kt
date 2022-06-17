package com.example.myfirstandroidapp

import android.app.Activity
import android.content.Intent

const val SEC_USER_NAME = "extraUserInput"
const val SEC_COUNTER = "extraSPStatus"

object NavigationManager {
    fun Activity.navigateToSecondScreen(
        name: String,
        counter: Int
    ) {
        Intent(this, SecondScreen::class.java).also {
            it.putExtra(SEC_USER_NAME, name)
            it.putExtra(SEC_COUNTER, counter)
            startActivity(it)
        }
    }

    fun Activity.navigateToRandomNumberGenerator(){     //tutaj będę potrzebował pomocy - nie działa mi to na recycledView
        Intent(this, RandomNumberGenerator::class.java)
    }
}