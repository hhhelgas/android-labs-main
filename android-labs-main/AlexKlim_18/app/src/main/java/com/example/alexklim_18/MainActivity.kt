package com.example.alexklim_18

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sunImageView: ImageView = findViewById(R.id.sun)
        val sunRiseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        sunImageView.startAnimation(sunRiseAnimation)

        val clockImageView: ImageView = findViewById(R.id.clock)
        val clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn)
        clockImageView.startAnimation(clockTurnAnimation)
    }
}