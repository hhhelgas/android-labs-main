package com.example.alexklim_26

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager


class MainActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences
    private var notifications_name = "NOTIFICATIONS"
    private var hints_name = "HINTS"
    private var cool_number_name = "COOL_NUMBER"
    private var text_style_name = "TEXT_STYLE"
    private var text_color_name = "TEXT_COLOR"
    private var glad_name = "GLAD_NUMBER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val settings_button : Button = findViewById(R.id.settings)
        val text_view : TextView = findViewById(R.id.textView)
        val cool_text : TextView = findViewById(R.id.cool_number_text)

        var final_text = ""

        settings_button.setOnClickListener {
            val intent = Intent(this@MainActivity, MyPreferenceActivity::class.java)
            startActivity(intent)
        }
        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this )

        val notifications_pref = sharedPreferences.getBoolean(notifications_name, true)
        val hints_pref = sharedPreferences.getBoolean(hints_name, true)
        val cool_number_pref = sharedPreferences.getInt(cool_number_name, 6)
        val text_style_pref = sharedPreferences.getString(text_style_name, "Обычный")
        val text_color_pref = sharedPreferences.getString(text_color_name, "Черный")
        val glad_pref = sharedPreferences.getBoolean(glad_name, false)

        Log.i("INFO", "$notifications_pref $hints_pref $text_color_pref $text_style_pref $glad_pref")

        if (notifications_pref) {
            final_text += "Уведомления включены\n"
        }
        if (hints_pref) {
            final_text += "Подсказки включены\n"
        }
        if (cool_number_pref == 17) {
         cool_text.text = "Вот это реально крутое число!"
        } else {
            cool_text.text = "Круто, но не очень"
        }
        when (text_style_pref) {
                "Обычный" -> {
                    cool_text.setTypeface(null, Typeface.NORMAL)
                    text_view.setTypeface(null, Typeface.NORMAL)
                }
                "Полужирный" -> {
                    cool_text.setTypeface(null, Typeface.BOLD)
                    text_view.setTypeface(null, Typeface.BOLD)
                }
                "Курсив" -> {
                    cool_text.setTypeface(null, Typeface.ITALIC)
                    text_view.setTypeface(null, Typeface.ITALIC)
                }
                "Полужирный+Курсив" -> {
                    cool_text.setTypeface(null, Typeface.BOLD_ITALIC)
                    text_view.setTypeface(null, Typeface.BOLD_ITALIC)
                }
        }
        final_text += "Стиль текста $text_style_pref\n"
        when (text_color_pref) {
                "Черный" -> {
                    cool_text.setTextColor(Color.BLACK)
                    text_view.setTextColor(Color.BLACK)
                }
                "Красный" -> {
                    cool_text.setTextColor(Color.RED)
                    text_view.setTextColor(Color.RED)
                }
                "Зеленый" -> {
                    cool_text.setTextColor(Color.GREEN)
                    text_view.setTextColor(Color.GREEN)
                }
                "Синий" -> {
                    cool_text.setTextColor(Color.BLUE)
                    text_view.setTextColor(Color.BLUE)
                }
        }
        final_text += "Цвет теста $text_color_pref\n"
        if (glad_pref && cool_number_pref == 17) {
            final_text += "Вы нашли крутое! Вы большой молодец!)"
        }

        text_view.text = final_text
    }

    override fun onResume() {
        super.onResume()
        var final_text = ""

        val text_view : TextView = findViewById(R.id.textView)
        val cool_text : TextView = findViewById(R.id.cool_number_text)

        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val notifications_pref = sharedPreferences.getBoolean(notifications_name, true)
        val hints_pref = sharedPreferences.getBoolean(hints_name, true)
        val cool_number_pref = sharedPreferences.getInt(cool_number_name, 6)
        val text_style_pref = sharedPreferences.getString(text_style_name, "Обычный")
        val text_color_pref = sharedPreferences.getString(text_color_name, "Черный")
        val glad_pref = sharedPreferences.getBoolean(glad_name, false)

        Log.i("INFO", "$notifications_pref $hints_pref $text_color_pref $text_style_pref $glad_pref")

        if (notifications_pref) {
            final_text += "Уведомления включены\n"
        }
        if (hints_pref) {
            final_text += "Подсказки включены\n"
        }
        if (cool_number_pref == 17) {
            cool_text.text = "Вот это реально крутое число!"
        } else {
            cool_text.text = "Круто, но не очень"
        }
        when (text_style_pref) {
            "Обычный" -> {
                cool_text.setTypeface(null, Typeface.NORMAL)
                text_view.setTypeface(null, Typeface.NORMAL)
            }
            "Полужирный" -> {
                cool_text.setTypeface(null, Typeface.BOLD)
                text_view.setTypeface(null, Typeface.BOLD)
            }
            "Курсив" -> {
                cool_text.setTypeface(null, Typeface.ITALIC)
                text_view.setTypeface(null, Typeface.ITALIC)
            }
            "Полужирный+Курсив" -> {
                cool_text.setTypeface(null, Typeface.BOLD_ITALIC)
                text_view.setTypeface(null, Typeface.BOLD_ITALIC)
            }
        }
        final_text += "Стиль текста $text_style_pref\n"
        when (text_color_pref) {
            "Черный" -> {
                cool_text.setTextColor(Color.BLACK)
                text_view.setTextColor(Color.BLACK)
            }
            "Красный" -> {
                cool_text.setTextColor(Color.RED)
                text_view.setTextColor(Color.RED)
            }
            "Зеленый" -> {
                cool_text.setTextColor(Color.GREEN)
                text_view.setTextColor(Color.GREEN)
            }
            "Синий" -> {
                cool_text.setTextColor(Color.BLUE)
                text_view.setTextColor(Color.BLUE)
            }
        }
        final_text += "Цвет теста $text_color_pref\n"
        if (glad_pref && cool_number_pref == 17) {
            final_text += "Вы нашли крутое! Вы большой молодец!)"
        }

        text_view.text = final_text
    }
}