package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalc = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalc.setOnClickListener {
            val weightStr = etWeight.text.toString()
            val heightStr = etHeight.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                if (height > 0) {
                    val bmi = weight / (height * height)

                    val category = when {
                        bmi < 18.5 -> "Underweight"
                        bmi < 25 -> "Normal Weight"
                        bmi < 30 -> "Overweight"
                        else -> "Obese"
                    }

                    tvResult.text = "BMI: %.2f\nCategory: %s".format(bmi, category)
                } else {
                    Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
            }
        }
    }
}