package com.example.testapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class BluetoothActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        val btButton: ImageButton = findViewById(R.id.bluetooth_button)
        btButton.setOnClickListener{handleBluetooth()}
    }

    private fun handleBluetooth(){
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
    }
}