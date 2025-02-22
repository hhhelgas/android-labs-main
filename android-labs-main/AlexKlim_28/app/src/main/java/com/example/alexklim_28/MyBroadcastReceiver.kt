package com.example.alexklim_28

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver(private val onReceiveAction: (String) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "org.example.alexklim_28.CUSTOM_ACTION") {
            val message = intent.getStringExtra("message") ?: "No Message"
            onReceiveAction(message)
        }
    }
}