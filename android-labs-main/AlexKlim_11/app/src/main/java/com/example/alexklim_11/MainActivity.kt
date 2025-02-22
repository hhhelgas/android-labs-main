package com.example.alexklim_11

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val textView = findViewById<TextView>(R.id.textView)
        when (item.itemId) {
            R.id.dog1 -> {
                textView.text = getText(R.string.answer_dog_male)
                return true
            }
            R.id.dog2 -> {
                textView.text = getText(R.string.answer_dog_female)
                return true
            }
            R.id.dog3 -> {
                textView.text = getText(R.string.answer_puppy)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}