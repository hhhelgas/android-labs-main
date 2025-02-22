package com.example.alexklim_9

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
//        val toast_text = getText(R.string.message)
//        val duration = Toast.LENGTH_SHORT
//        val toast = Toast.makeText(applicationContext, text, duration)
        val inflater = layoutInflater
        val container = findViewById<ViewGroup>(R.id.custom_toast_container)
        val layout : View = inflater.inflate(R.layout.custom_toast, container)

        button.setOnClickListener() {
            with (Toast(applicationContext)) {
                setGravity(Gravity.TOP or Gravity.LEFT, 0, 0)
                duration = Toast.LENGTH_SHORT
                view = layout
                show()
            }
        }
    }
}