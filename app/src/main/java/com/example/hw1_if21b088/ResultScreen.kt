package com.example.hw1_if21b088

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        val resultFromMainActivity = intent.getIntExtra("RESULT_VALUE", 0)
        val resultScreenResult = findViewById<TextView>(R.id.resultScreenResult)

        resultScreenResult.text = "$resultFromMainActivity"
        Log.i("Second", "Calc Result")
    }
}