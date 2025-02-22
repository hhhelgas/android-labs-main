package com.example.alexklim_8;

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog.Builder
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)

        val cool_button : Button = findViewById(R.id.cool_button_2)

        cool_button.setOnClickListener() {
            val builder: Builder = Builder(this, R.style.AppCompatAlertDialogStyle)
            builder.setTitle("Вопрос")
            builder.setMessage("Стильно?")
            builder.setPositiveButton("Да", null)
            builder.setNegativeButton("Нет", null)
            builder.show()
        }
    }
}
