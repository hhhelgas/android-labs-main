package com.example.alexklim_25

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences
    private val APP_PREFERENCES_COUNTER = "counter"
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crowButton = findViewById<Button>(R.id.crowButton)
        val infoTextView = findViewById<TextView>(R.id.infoTextView)
        val reset_crow = findViewById<Button>(R.id.stop_count)

        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)

        crowButton.setOnClickListener {
            counter = ++counter
            infoTextView.text = getString(R.string.i_counted, counter)
        }

        reset_crow.setOnClickListener {
            counter = 0
            val editor = prefs.edit()
            editor.putInt(APP_PREFERENCES_COUNTER, 0).apply()
            infoTextView.text = getString(R.string.crow_view)
        }
    }

    override fun onPause() {
        super.onPause()

        val editor = prefs.edit()
        editor.putInt(APP_PREFERENCES_COUNTER, counter).apply()
    }

    override fun onResume() {
        super.onResume()

        if(prefs.contains(APP_PREFERENCES_COUNTER)) {
            counter = prefs.getInt(APP_PREFERENCES_COUNTER, 0)
            val infoTextView = findViewById<TextView>(R.id.infoTextView)
            infoTextView.text = getString(R.string.i_counted, counter)
        }
    }
}
