package com.example.temperatureconverterapp


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTemp = findViewById<EditText>(R.id.etTemp)
        val rgType = findViewById<RadioGroup>(R.id.rgType)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val input = etTemp.text.toString()

            if (input.isNotEmpty()) {
                val temp = input.toDouble()
                val selectedId = rgType.checkedRadioButtonId

                if (selectedId == R.id.rbToFahrenheit) {
                    // Celsius to Fahrenheit
                    val result = (temp * 9/5) + 32
                    tvResult.text = "Result: %.2f °F".format(result)
                } else {
                    // Fahrenheit to Celsius
                    val result = (temp - 32) * 5/9
                    tvResult.text = "Result: %.2f °C".format(result)
                }
            } else {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            }
        }
    }
}