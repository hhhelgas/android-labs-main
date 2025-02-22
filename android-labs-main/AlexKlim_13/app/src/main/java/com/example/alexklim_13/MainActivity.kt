package com.example.alexklim_13

import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)
        val brightness_level = findViewById<TextView>(R.id.brightness)
        val button = findViewById<Button>(R.id.button)
        val seekBarBrightness = findViewById<SeekBar>(R.id.seekBar)

        button.setOnClickListener() {
            val intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        val resources: Resources = resources
        val displayMetrics = resources.displayMetrics
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels

        text.text = "Параметры экрана\nШирина: $width\nВысота: $height\n"

        seekBarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val backLightValue = progress.toFloat() / 100

                val layoutParams = window.attributes
                layoutParams.screenBrightness = backLightValue
                window.attributes = layoutParams

                brightness_level.text = "Уровень яркости: ${(backLightValue * 4096).toInt()}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}