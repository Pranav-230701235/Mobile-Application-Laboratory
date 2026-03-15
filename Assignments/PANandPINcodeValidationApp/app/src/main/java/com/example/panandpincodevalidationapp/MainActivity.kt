package com.example.panandpincodevalidationapp
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPan = findViewById<EditText>(R.id.etPanCard)
        val etPin = findViewById<EditText>(R.id.etPincode)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {
            val panValue = etPan.text.toString().trim()
            val pinValue = etPin.text.toString().trim()

            if (panValue.isEmpty() || pinValue.isEmpty()) {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val panRegex = "^[A-Z0-9]{10}$"
            if (!panValue.matches(Regex(panRegex, RegexOption.IGNORE_CASE))) {
                etPan.error = "PAN must be 10 alphanumeric characters"
                return@setOnClickListener
            }

            val pinRegex = "^[0-9]{6}$"
            if (!pinValue.matches(Regex(pinRegex))) {
                etPin.error = "Pincode must be exactly 6 digits"
            } else {
                Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show()
            }
        }
    }
}