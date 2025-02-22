package com.example.alexklim_15

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val radio : RadioButton = findViewById(R.id.radioButtonParrots)
        val textEdit = findViewById<EditText>(R.id.editText)
        textEdit.isCursorVisible = false
        val button : Button = findViewById(R.id.convertButton)
        val clear : Button = findViewById(R.id.clearButton)

        clear.setOnClickListener {
            textEdit.text = SpannableStringBuilder("")
        }

        button.setOnClickListener {
            if (textEdit.text.isEmpty()) {
                Toast.makeText(
                    applicationContext, "Введите длину попугая!",
                    Toast.LENGTH_LONG).show()
            }
            else {
                val inputValue = textEdit.text.toString().toFloat()
                if (radio.isChecked) {
                    textEdit.text = SpannableStringBuilder(convertParrotToBoas(inputValue).toString())
                } else {
                    textEdit.text = SpannableStringBuilder(convertBoasToParrot(inputValue).toString())
                }
            }
        }
    }
    private fun convertParrotToBoas(parrot: Float): Float = (parrot * 7.6).toFloat()

    private fun convertBoasToParrot(meter: Float): Float = (meter / 7.6).toFloat()
}