package com.example.alexklim_12

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val viewClickListener: View.OnClickListener = View.OnClickListener { v : View ->
            val popupMenu = PopupMenu(this, v)
            popupMenu.inflate(R.menu.popupmenu)

            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.g1_item_1 -> {
                        Toast.makeText(applicationContext,
                            getText(R.string.words_1),
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.g1_item_2 -> {
                        Toast.makeText(applicationContext,
                            getText(R.string.words_2),
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.g1_item_3 -> {
                        Toast.makeText(applicationContext,
                            getText(R.string.words_3),
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.g2_item_1 -> {
                        Toast.makeText(applicationContext,
                            getText(R.string.words_4),
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.g2_item_2 -> {
                        Toast.makeText(applicationContext,
                            getText(R.string.words_5),
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.g2_item_3 -> {
                        Toast.makeText(applicationContext,
                            getText(R.string.words_6),
                            Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }

        button.setOnClickListener(viewClickListener)
        textView.setOnClickListener(viewClickListener)
        imageView.setOnClickListener(viewClickListener)
    }
}