package com.example.alexklim_16

import android.os.Bundle
import android.util.Log
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
        Log.i("MainActivity", "onCreate() called")
        Toast.makeText(applicationContext, "onCreate()", Toast.LENGTH_SHORT).show();
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart() called")
        Toast.makeText(applicationContext, "onStart()", Toast.LENGTH_SHORT).show();
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart() called")
        Toast.makeText(applicationContext, "onRestart()", Toast.LENGTH_SHORT).show();
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume() called")
        Toast.makeText(applicationContext, "onResume()", Toast.LENGTH_SHORT).show();
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause() called")
        Toast.makeText(applicationContext, "onPause()", Toast.LENGTH_SHORT).show();
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop() called")
        Toast.makeText(applicationContext, "onStop()", Toast.LENGTH_SHORT).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy() called")
        Toast.makeText(applicationContext, "onDestroy()", Toast.LENGTH_SHORT).show();
    }
}