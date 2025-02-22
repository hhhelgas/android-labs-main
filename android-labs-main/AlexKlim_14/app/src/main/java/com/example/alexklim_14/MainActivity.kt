package com.example.alexklim_14

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {
    companion object {
        const val CHANNEL_ID = "best_ID"
        const val CHANNEL_NAME = "best_channel"
        const val NOTIFY_ID = 1
        const val BIG_IMG_NOTIFY_ID = 2
        const val BIG_TEXT_NOTIFY_ID = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        val button: Button = findViewById(R.id.button)
        val deleteButton : Button = findViewById(R.id.delete_notify)
        val bigImgButton : Button = findViewById(R.id.big_img)
        val bigTextButton : Button = findViewById(R.id.big_text)
        val deleteNotification : Button = findViewById(R.id.delete_all_notify)

        button.setOnClickListener {
            sendNotification()
        }

        deleteButton.setOnClickListener {
            deleteNotification()
        }

        bigTextButton.setOnClickListener {
            sendNotificationBigText()
        }

        bigImgButton.setOnClickListener {
            sendNotificationBigImg()
        }

        deleteNotification.setOnClickListener {
            deleteNotifications()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = getString(R.string.channel_descroption)
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                        1
                    )
                } else {
                    val notificationManager: NotificationManager =
                        getSystemService(NotificationManager::class.java)
                    notificationManager.createNotificationChannel(channel)
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification() {
        val intent = Intent(this, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.play_store_512)
            .setContentTitle(getString(R.string.title))
            .setContentText(getString(R.string.message))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.check_circle_24px, getString(R.string.yes), pendingIntent)
            .addAction(R.drawable.close_24px, getString(R.string.no), pendingIntent)
            .addAction(R.drawable.menu_24px, getString(R.string.menu), pendingIntent)

        NotificationManagerCompat.from(this).notify(NOTIFY_ID, builder.build())
    }

    @SuppressLint("MissingPermission")
    private fun sendNotificationBigImg() {
        val intent = Intent(this, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.play_store_512)
            .setContentTitle(getString(R.string.title))
            .setContentText(getString(R.string.message))
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(
                        BitmapFactory.decodeResource(
                            resources,
                            R.drawable.working
                        )
                    ))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)

        NotificationManagerCompat.from(this).notify(BIG_IMG_NOTIFY_ID, builder.build())
    }

    @SuppressLint("MissingPermission")
    private fun sendNotificationBigText() {
        val intent = Intent(this, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.play_store_512)
            .setContentTitle(getString(R.string.title))
            .setContentText(getString(R.string.message))
            .setStyle(NotificationCompat.BigTextStyle().bigText(getString(R.string.big_message)))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)

        NotificationManagerCompat.from(this).notify(BIG_TEXT_NOTIFY_ID, builder.build())
    }

    private fun deleteNotifications() {
        NotificationManagerCompat.from(this).cancelAll();
    }

    private fun deleteNotification() {
        NotificationManagerCompat.from(this).cancel(NOTIFY_ID)
    }
}