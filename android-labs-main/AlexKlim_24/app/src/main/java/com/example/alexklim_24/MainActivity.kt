package com.example.alexklim_24

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity : AppCompatActivity() {

    private val REQUEST_TAKE_PHOTO = 1
    private val REQUEST_TAKE_VIDEO = 2
    private val PIC_CROP = 3
    private var picUri: Uri? = null
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        val take_foto_btn: Button = findViewById(R.id.take_foto)

        take_foto_btn.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }

        val take_video_btn: Button = findViewById(R.id.take_video)

        take_video_btn.setOnClickListener {
            val takeVideoIntent = Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA)
            try {
                startActivityForResult(takeVideoIntent, REQUEST_TAKE_VIDEO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_TAKE_PHOTO -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    picUri = data.data
                    imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            PIC_CROP -> {
                val extras: Bundle? = data?.extras
                val thePic = extras?.getParcelable<Bitmap>("data")
                imageView.setImageBitmap(thePic)
            }
            else -> {
                Toast.makeText(this, "Wrong request code", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveFullImage() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file = File(
            Environment.getExternalStorageDirectory(),
            "test.jpg"
        )
        val outputFileUri = Uri.fromFile(file)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
        startActivityForResult(intent, REQUEST_TAKE_PHOTO)
    }
}
