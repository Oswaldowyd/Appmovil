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

class Imcactivity : AppCompatActivity() {
    private lateinit var txtAltura : EditText
    private lateinit var txtPeso : EditText
    private lateinit var txtResultado : TextView
    private lateinit var btnLimpiar : Button
    private lateinit var btnCerrar : Button
    private lateinit var btnCalcular : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun iniciarComponentes(){
        txtAltura = findViewById(R.id.txtAltura) as EditText
        txtPeso = findViewById(R.id.txtPeso)
        txtResultado = findViewById(R.id.txtResultado) as TextView

        btnCerrar = findViewById(R.id.btnCerrar) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCalcular = findViewById(R.id.btnCalcular) as Button
    }

    fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            //validar





            if(txtPeso.text.toString().contentEquals(charSequence = "")
                !! txtAltura.text.toString().contentEquals(charSequence = ""))
        }
    }

    fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            Toast.makeText()
        })
    }
}