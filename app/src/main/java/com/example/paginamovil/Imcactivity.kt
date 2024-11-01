package com.example.imccalculator

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var weightEditText: EditText? = null
    private var heightEditText: EditText? = null
    private var calculateButton: Button? = null
    private var resultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightEditText = findViewById<EditText>(R.id.weightEditText)
        heightEditText = findViewById<EditText>(R.id.heightEditText)
        calculateButton = findViewById<Button>(R.id.calculateButton)
        resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener(View.OnClickListener { calculateBMI() })
    }

    private fun calculateBMI() {
        val weightString = weightEditText!!.text.toString()
        val heightString = heightEditText!!.text.toString()

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            val weight = weightString.toDouble()
            val height = heightString.toDouble() / 100 // Convertir de cm a metros
            val bmi = weight / (height * height)

            resultTextView!!.text = String.format("Tu IMC es: %.2f", bmi)
        } else {
            resultTextView!!.text = "Por favor, ingresa peso y altura."
        }
    }
}