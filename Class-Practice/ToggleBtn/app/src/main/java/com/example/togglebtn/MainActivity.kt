package com.example.togglebtn

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvMessage.visibility = View.VISIBLE
            } else {
                tvMessage.visibility = View.INVISIBLE
            }
        }
    }
}