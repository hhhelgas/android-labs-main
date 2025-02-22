package com.example.alexklim_4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootLayout: ConstraintLayout = findViewById(R.id.main)
        val textColor : TextView = findViewById(R.id.colorText)
        val redButton : Button = findViewById(R.id.button_red)
        val yellowButton : Button = findViewById(R.id.button_yellow)
        val greenButton : Button = findViewById(R.id.button_green)

        redButton.setOnClickListener {
            textColor.text = getString(R.string.button_red)
            rootLayout.setBackgroundColor(getColor(R.color.red))
        }

        yellowButton.setOnClickListener {
            textColor.text = getString(R.string.button_yellow)
            rootLayout.setBackgroundColor(getColor(R.color.yellow))
        }

        greenButton.setOnClickListener {
            textColor.text = getString(R.string.button_green)
            rootLayout.setBackgroundColor(getColor(R.color.green))
        }
    }
}