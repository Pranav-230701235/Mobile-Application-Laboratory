package com.example.validationapp
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etID = findViewById<EditText>(R.id.etID)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {
            val user = etUsername.text.toString().trim()
            val id = etID.text.toString().trim()

            if (user.isEmpty() || id.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else if (!user.matches(Regex("^[a-zA-Z ]+$"))) {
                Toast.makeText(this, "Name must contain only alphabets", Toast.LENGTH_SHORT).show()
            }
            else if (!id.matches(Regex("^[0-9]{4}$"))) {
                Toast.makeText(this, "ID must be exactly 4 digits", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show()
            }
        }
    }
}