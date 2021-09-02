package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import okhttp3.*
import java.io.IOException

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
        runPostApi()
    }

    private fun handleAlarm() {
        Toast.makeText(this, "You're having a seizure!", Toast.LENGTH_SHORT).show()
    }

    private fun runPostApi() {
        val url = "http://145.93.92.187:8000/seizure/create"

        val formBody = FormBody.Builder()
            .add("personId", "1")
            .add("time", "2-Sep-2021 12:10:50")
            .add("endTime", "2-Sep-2021 12:15:50")
            .add("magnitude", "8")
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