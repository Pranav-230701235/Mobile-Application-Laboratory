package com.example.simplecalculator

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

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val buttons: List<Button> = listOf(
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSub),
            findViewById(R.id.btnMul),
            findViewById(R.id.btnDiv)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                val n1Str = etNum1.text.toString()
                val n2Str = etNum2.text.toString()

                if (n1Str.isNotEmpty() && n2Str.isNotEmpty()) {
                    val n1 = n1Str.toDouble()
                    val n2 = n2Str.toDouble()
                    var res = 0.0

                    when (button.id) {
                        R.id.btnAdd -> res = n1 + n2
                        R.id.btnSub -> res = n1 - n2
                        R.id.btnMul -> res = n1 * n2
                        R.id.btnDiv -> {
                            if (n2 != 0.0) {
                                res = n1 / n2
                            } else {
                                Toast.makeText(this, R.string.error_divide_zero, Toast.LENGTH_SHORT).show()
                                return@setOnClickListener
                            }
                        }
                    }
                    tvResult.text = getString(R.string.result_text, res.toString())
                } else {
                    Toast.makeText(this, R.string.error_enter_numbers, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
