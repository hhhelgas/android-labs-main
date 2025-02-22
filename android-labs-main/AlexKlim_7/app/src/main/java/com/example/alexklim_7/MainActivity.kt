package com.example.alexklim_7

import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var text : TextView = findViewById(R.id.orientation_text)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            text.text = getText(R.string.vertical)
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            text.text = getText(R.string.horizontal)
        }
    }
}