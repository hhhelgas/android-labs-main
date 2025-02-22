package com.example.alexklim_6

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text : TextView = findViewById(R.id.textFromFirst)

        val name = intent.getStringExtra("name")
        val message = intent.getStringExtra("message")

        text.text = "$name передал(а) вам $message"
//        text.text =
        val button : ImageButton = findViewById(R.id.imageButtonSecond)

        button.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}