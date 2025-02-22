package com.example.alexklim_20

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        onBackPressedDispatcher.addCallback(this /* lifecycle owner */, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.v("State", "handleOnBackPressed")
                showExitConfirmationDialog()
            }
        })

        val editSearch = findViewById<EditText>(R.id.editSearch)
        editSearch.setOnEditorActionListener { textView, actionId, keyEvent ->
            onEditorAction(textView, actionId, keyEvent)
        }
        val editGo = findViewById<EditText>(R.id.editGo)
        editGo.setOnEditorActionListener { textView, actionId, keyEvent ->
            onEditorAction(textView, actionId, keyEvent)
        }
        val editSend = findViewById<EditText>(R.id.editSend)
        editSend.setOnEditorActionListener { textView, actionId, keyEvent ->
            onEditorAction(textView, actionId, keyEvent)
        }
        val editNext = findViewById<EditText>(R.id.editNext)
        editNext.setOnEditorActionListener { textView, actionId, keyEvent ->
            onEditorAction(textView, actionId, keyEvent)
        }
        val editDone = findViewById<EditText>(R.id.editDone)
        editDone.setOnEditorActionListener { textView, actionId, keyEvent ->
            onEditorAction(textView, actionId, keyEvent)
        }
    }

    private fun onEditorAction(textView: TextView?, i: Int, keyEvent: KeyEvent?): Boolean {
        Log.d("WHALETAG", "Что то собирается нажаться")
        when (i) {
            EditorInfo.IME_ACTION_SEARCH -> {
                if (textView != null) {
                    if (textView.text == "Время") {
                        Toast.makeText(this, "К сожалению времени больше - не найти", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Поиск: " + textView.text, Toast.LENGTH_SHORT).show()
                    }
                }
                return true
            }
            EditorInfo.IME_ACTION_GO -> {
                if (textView != null) {
                    Toast.makeText(this, "Вперёд: " + textView.text, Toast.LENGTH_SHORT).show()
                }
                return true
            }
            EditorInfo.IME_ACTION_SEND -> {
                if (textView != null) {
                    Toast.makeText(this, "Отправим: " + textView.text, Toast.LENGTH_SHORT).show()
                }
                return true
            }
            EditorInfo.IME_ACTION_NEXT -> {
                if (textView != null) {
                    Toast.makeText(this, "Далее: " + textView.text, Toast.LENGTH_SHORT).show()
                }
                return true
            }
            EditorInfo.IME_ACTION_DONE -> {
                if (textView != null) {
                    Toast.makeText(this, "Хорошо: " + textView.text, Toast.LENGTH_SHORT).show()
                }
                return true
            }
            else -> return false
        }
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        Log.v("State", "onUserLeaveHint")
        val toast = Toast.makeText(this@MainActivity, "Нажата кнопка HOME", Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_MENU -> {
                Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            KeyEvent.KEYCODE_VOLUME_UP -> {
                event.startTracking()
                return true
            }

            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                    .show()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this@MainActivity).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Таки да") { _, _ ->
                finish()
            }

            setNegativeButton("Нет"){_, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }
}