package com.example.digitalcafeloginvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val pass = etPassword.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]+$"
            if (!email.matches(Regex(emailPattern))) {
                etEmail.error = "Enter a valid email address"
                return@setOnClickListener
            }


            val passPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{12,}$"

            if (!pass.matches(Regex(passPattern))) {
                etPassword.error = "Password must be 12+ chars with 1 Upper, 1 Digit, and 1 Special char"
            } else {
                Toast.makeText(this, "Login Validated Successfully!", Toast.LENGTH_LONG).show()
            }
        }
    }
}