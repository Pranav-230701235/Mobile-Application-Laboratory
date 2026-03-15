package com.example.radiobtn

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)
        val radioGroup = findViewById<RadioGroup>(R.id.colorRadioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbRed -> mainLayout.setBackgroundColor(Color.RED)
                R.id.rbGreen -> mainLayout.setBackgroundColor(Color.GREEN)
                R.id.rbBlue -> mainLayout.setBackgroundColor(Color.BLUE)
            }
        }
    }
}