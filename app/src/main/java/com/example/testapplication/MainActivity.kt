package com.example.testapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import okhttp3.*
import java.io.IOException
import java.text.SimpleDateFormat

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
        val intent = Intent(this, LogActivity::class.java)
        startActivity(intent)
    }

    private fun handleAlarm() {
        Toast.makeText(this, "You're having a seizure!", Toast.LENGTH_SHORT).show()
        runPostApi()
    }

    private fun runPostApi() {
        val url = "http://145.93.92.187:8000/seizure/create"

        val personId = 1
        val rndMagnitude = (1..10).random()

        val formBody = FormBody.Builder()
            .add("personId", personId.toString())
            .add("time", "3-Sep-2021 13:00:50")
            .add("endTime", "3-Sep-2021 13:05:50")
            .add("magnitude", rndMagnitude.toString())
            .build()

        val request = Request.Builder().url(url)
            .post(formBody)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                println(response.body())
            }

            override fun onFailure(call: Call, e: IOException) {
                println(e.message.toString())
            }
        })
    }
}