package com.example.paginamovil

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    private lateinit var txtPeso: EditText
    private lateinit var txtAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    private lateinit var lblResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        iniciarComponentes()
        eventosBotones()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun iniciarComponentes() {
        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)
        lblResultado = findViewById(R.id.lblResultado)
    }

    private fun eventosBotones() {
        btnCalcular.setOnClickListener(View.OnClickListener {
            val pesoString = txtPeso.text.toString()
            val alturaString = txtAltura.text.toString()

            if (pesoString.isBlank() || alturaString.isBlank()) {
                Toast.makeText(applicationContext, "Por favor, ingresa peso y altura.", Toast.LENGTH_SHORT).show()
            } else {
                val peso = pesoString.toDouble()
                val altura = alturaString.toDouble() / 100  // Convertir altura de cm a metros
                val imc = peso / (altura * altura)
                lblResultado.text = String.format("Tu IMC es: %.2f", imc)
            }
        })

        btnLimpiar.setOnClickListener {
            txtPeso.setText("")
            txtAltura.setText("")
            lblResultado.text = ""
        }

        btnCerrar.setOnClickListener {
            finish()
        }
    }
}
