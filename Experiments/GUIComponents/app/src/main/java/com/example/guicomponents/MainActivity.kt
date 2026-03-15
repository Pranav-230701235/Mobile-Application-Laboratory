package com.example.guicomponents

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSample = findViewById<TextView>(R.id.tvSample)
        val btnChange = findViewById<Button>(R.id.btnChange)

        btnChange.setOnClickListener {
            tvSample.setTextColor(Color.RED)

            tvSample.setTypeface(null, Typeface.BOLD_ITALIC)

            Toast.makeText(this, "Text Style Updated!", Toast.LENGTH_SHORT).show()
        }
    }
}