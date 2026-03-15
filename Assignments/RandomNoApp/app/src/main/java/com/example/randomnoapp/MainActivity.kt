package com.example.randomnoapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMin = findViewById<EditText>(R.id.etMin)
        val etMax = findViewById<EditText>(R.id.etMax)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnGenerate.setOnClickListener {
            val minStr = etMin.text.toString()
            val maxStr = etMax.text.toString()

            if (minStr.isNotEmpty() && maxStr.isNotEmpty()) {
                val min = minStr.toInt()
                val max = maxStr.toInt()

                if (min < max) {
                    val randomNumber = Random.nextInt(min, max + 1)
                    tvResult.text = randomNumber.toString()
                } else {
                    Toast.makeText(this, "Min must be less than Max", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
            }
        }
    }
}