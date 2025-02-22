package com.example.alexklim_6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val goToSecondActivity : Button = findViewById(R.id.secondActivity)
        val aboutActivity : Button = findViewById(R.id.aboutAuthor)

        val editName : EditText = findViewById(R.id.editName)
        val editMessage : EditText = findViewById(R.id.editMessgae)

        aboutActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        goToSecondActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)

            intent.putExtra("name", editName.text.toString())
            intent.putExtra("message", editMessage.text.toString())

            startActivity(intent)
        }
    }
}