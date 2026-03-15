package com.example.techloungeapp
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        val btnCheckIn = findViewById<Button>(R.id.btnCheckIn)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)

        btnCheckIn.setOnClickListener {
            count++
            tvCounter.text = count.toString()
        }

        btnCheckOut.setOnClickListener {
            if (count > 0) {
                count--
                tvCounter.text = count.toString()
            } else {
                Toast.makeText(this, "Lounge is already empty!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
