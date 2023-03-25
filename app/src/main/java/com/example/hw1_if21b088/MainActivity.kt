package com.example.hw1_if21b088

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val logTag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(logTag, "onCreate is called")

        //components
        var calcResult = 0
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.calculatorResult)
        val navigatorButton = findViewById<Button>(R.id.navigate)
        val number1EditText = findViewById<EditText>(R.id.number1)
        val number2EditText = findViewById<EditText>(R.id.number2)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val seekBarProgress = findViewById<TextView>(R.id.seekBarProgress)

        resultTextView.text = "0"
        //calc Button onClick Event
        calculateButton.setOnClickListener {

            Log.e(logTag, "calculateButton is called")
            val number1 = number1EditText.text.toString().toIntOrNull() ?: 0
            val number2 = number2EditText.text.toString().toIntOrNull() ?: 0

            calcResult = number1 + number2
            Log.e(logTag, "$calcResult")

            //val number2: Number = findViewById<TextView>()
            //calcResult = calculateResult()
            resultTextView.text = "$calcResult"
        }

        navigatorButton.setOnClickListener {
            Log.e(logTag, "navigator is called")
            val resultScreen = Intent(this, ResultScreen::class.java)

            val number1 = number1EditText.text.toString().toIntOrNull() ?: 0 //falls null zahl wird zu 0 umgewandelt
            val number2 = number2EditText.text.toString().toIntOrNull() ?: 0

            calcResult = number1 + number2
            Log.e(logTag, "Navigator calc result $calcResult")

            resultScreen.putExtra("RESULT_VALUE", calcResult)
            startActivity(resultScreen)

        }
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                seekBarProgress.text = progress.toString()
                Log.e(logTag, "SeekBar $progress")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }
}