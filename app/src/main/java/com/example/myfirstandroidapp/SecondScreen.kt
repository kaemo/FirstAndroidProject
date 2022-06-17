package com.example.myfirstandroidapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondScreen : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        // navbar

        findViewById<ImageButton>(R.id.imageButtonChevron).setOnClickListener {
            onBackPressed()
        }

        // RecyledView

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

        // rest of the screen

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
    }
}