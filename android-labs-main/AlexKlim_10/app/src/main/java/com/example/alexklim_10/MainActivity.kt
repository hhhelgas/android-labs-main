package com.example.alexklim_10

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var soundPool: SoundPool
    private lateinit var assetManager : AssetManager

    private var chickSound : Int = 0
    private var cowSound : Int = 0
    private var dogSound : Int = 0
    private var elephantSound : Int = 0
    private var frogSound : Int = 0
    private var whaleSound : Int = 0

    private var streamID : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val chickImage : ImageView = findViewById(R.id.chick)
        val cowImage : ImageView = findViewById(R.id.cow)
        val dogImage : ImageView = findViewById(R.id.dog)
        val elephantImage : ImageView = findViewById(R.id.elephant)
        val frogImage : ImageView = findViewById(R.id.frog)
        val whaleImage : ImageView = findViewById(R.id.whale)

        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .build()

        assetManager = assets

        chickSound = loadSound("chick.ogg")
        cowSound = loadSound("cow.ogg")
        dogSound = loadSound("dog.ogg")
        elephantSound = loadSound("elephant.ogg")
        frogSound = loadSound("frog.ogg")
        whaleSound = loadSound("whale.ogg")

        chickImage.setOnClickListener {
            playSound(chickSound)
        }
        cowImage.setOnClickListener {
            playSound(cowSound)
        }
        dogImage.setOnClickListener {
            playSound(dogSound)
        }
        elephantImage.setOnClickListener {
            playSound(elephantSound)
        }
        frogImage.setOnClickListener {
            playSound(frogSound)
        }
        whaleImage.setOnClickListener {
            playSound(whaleSound)
        }
    }

    override fun onPause() {
        super.onPause()

        soundPool.release()
    }

    private fun playSound(sound: Int): Int {
        if (sound > 0) {
            streamID = soundPool.play(sound, 1F, 1F, 1, 0, 1F)
        }
        return streamID
    }

    private fun loadSound(fileName: String): Int {
        val afd: AssetFileDescriptor = try {
            application.assets.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("Meow", "Не могу загрузить файл $fileName")

            return -1
        }
        return soundPool.load(afd, 1)
    }
}