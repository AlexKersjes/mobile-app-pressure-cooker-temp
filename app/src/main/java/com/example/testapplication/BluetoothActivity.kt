package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class BluetoothActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        val btButton: ImageButton = findViewById(R.id.bluetooth_button)
        btButton.setOnClickListener{handleBluetooth()}
    }

    private fun handleBluetooth(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }
}