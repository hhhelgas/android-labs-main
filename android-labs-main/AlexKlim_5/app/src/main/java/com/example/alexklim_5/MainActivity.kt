package com.example.alexklim_5

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val cat_1 : ImageView = findViewById(R.id.cat_1)
        val cat_2 : ImageView = findViewById(R.id.cat_2)
        val cat_3 : ImageView = findViewById(R.id.cat_3)
        val cat_4 : ImageView = findViewById(R.id.cat_4)

        val cat_say_1 : TextView = findViewById(R.id.cat_say_1)
        val cat_say_2 : TextView = findViewById(R.id.cat_say_4)
        val cat_say_3 : TextView = findViewById(R.id.cat_say_2)
        val cat_say_4 : TextView = findViewById(R.id.cat_say_3)

        cat_1.setOnClickListener {
            val phrases = listOf (
                getString(R.string.say_1_1),
                getString(R.string.say_1_2),
                getString(R.string.say_1_3)
            )

            cat_say_1.text = phrases[rand(0, 2)]
        }

        cat_2.setOnClickListener {
            val phrases = listOf (
                getString(R.string.say_2_1),
                getString(R.string.say_2_2),
                getString(R.string.say_2_3)
            )

            cat_say_2.text = phrases[rand(0, 2)]
        }

        cat_3.setOnClickListener {
            val phrases = listOf (
                getString(R.string.say_3_1),
                getString(R.string.say_3_2),
                getString(R.string.say_3_3)
            )

            cat_say_3.text = phrases[rand(0, 2)]
        }

        cat_4.setOnClickListener {
            val phrases = listOf (
                getString(R.string.say_4_1),
                getString(R.string.say_4_2),
                getString(R.string.say_4_3)
            )

            cat_say_4.text = phrases[rand(0, 2)]
        }
    }
}