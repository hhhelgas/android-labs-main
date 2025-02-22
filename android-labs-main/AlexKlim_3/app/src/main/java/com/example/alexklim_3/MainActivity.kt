package com.example.alexklim_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var crowCounter = 0

        val text : TextView = findViewById(R.id.mainText)
        val crowText : TextView = findViewById(R.id.crowText)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            text.text = getString(R.string.good_people)
        }

        val crowCounterButton : Button = findViewById(R.id.crowCounter)
        crowCounterButton.setOnClickListener {
            crowCounter++
            crowText.text = getString(R.string.crow_counter) + crowCounter.toString()
        }

        val resetButton : Button = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            crowCounter = 0
            crowText.text = getString(R.string.crow_counter)
        }
    }
}