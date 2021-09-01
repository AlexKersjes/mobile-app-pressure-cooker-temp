package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recordbutton: Button = findViewById(R.id.RecordButton)
        recordbutton.setOnClickListener{handleRecord()}
        val alarmbutton: ImageButton = findViewById(R.id.AlarmButton)
        alarmbutton.setOnClickListener{handleAlarm()}
    }

    private fun handleRecord() {

    }

    private fun handleAlarm() {
        Toast.makeText(this, "You're having a seizure!", Toast.LENGTH_SHORT).show()
    }
}