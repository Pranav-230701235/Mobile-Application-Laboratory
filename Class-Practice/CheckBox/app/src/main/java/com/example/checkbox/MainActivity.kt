package com.example.checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cbPizza = findViewById<CheckBox>(R.id.cbPizza)
        val cbBurger = findViewById<CheckBox>(R.id.cbBurger)
        val cbCoffee = findViewById<CheckBox>(R.id.cbCoffee)
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val tvBillReceipt = findViewById<TextView>(R.id.tvBillReceipt)

        btnOrder.setOnClickListener {
            var total = 0
            val receipt = StringBuilder()

            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val currentDate = sdf.format(Date())

            receipt.append("***** RAJALAKSHMI CAFE *****\n")
            receipt.append("Date: $currentDate\n")
            receipt.append("----------------------------\n")
            receipt.append(String.format("%-15s %s\n", "Item", "Price"))
            receipt.append("----------------------------\n")

            if (cbPizza.isChecked) {
                total += 150
                receipt.append(String.format("%-15s %s\n", "Pizza", "Rs. 150"))
            }
            if (cbBurger.isChecked) {
                total += 120
                receipt.append(String.format("%-15s %s\n", "Burger", "Rs. 120"))
            }
            if (cbCoffee.isChecked) {
                total += 80
                receipt.append(String.format("%-15s %s\n", "Coffee", "Rs. 80"))
            }

            if (total > 0) {
                receipt.append("----------------------------\n")
                receipt.append(String.format("%-15s Rs. %d\n", "TOTAL BILL:", total))
                receipt.append("----------------------------\n")
                receipt.append("   Thank you for your order!")

                tvBillReceipt.text = receipt.toString()
                tvBillReceipt.setTextColor(resources.getColor(android.R.color.black))
            } else {
                tvBillReceipt.text = "Please select at least one item."
                tvBillReceipt.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            }
        }
    }
}