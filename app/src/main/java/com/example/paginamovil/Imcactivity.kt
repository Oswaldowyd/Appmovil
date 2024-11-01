package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class grados : AppCompatActivity() {
    private lateinit var txtCantidad : EditText
    private lateinit var  txtResultado: TextView
    private lateinit var  rbdCel: RadioButton
    private lateinit var  rbdFar: RadioButton

    private lateinit var  btnCalcular: Button
    private lateinit var  btnLimpiar: Button
    private lateinit var  btnCerrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponentes(){
        txtCantidad=findViewById(R.id.txtCantidad) as EditText
        txtResultado=findViewById(R.id.txtResultado as TextView
                rbdCel=findViewById(R.id.rbdCel) as RadioButton
                rbdFar=findViewById(R.id.rbdFar) as RadioButton
                btnCalcular=findViewById(R.id.btnCalcular) as Button
                btnLimpiar=findViewById(R.id.btnLimpiar) as Button
                btnCerrar=findViewById(R.id.btnCerrar) as Button
    }

    public fun eventosClick(){
        btnCalcular.setOnClickListener(View.OnClickListener){
            if (txtCantidad.text.toString().contentEquals(charSequence = )){
                Toast.makeText(context: this,text: "falto capturar entidad", Toast.LENGTH_SHORT).show();
            }
            else {
                var cantidad : Float = txtCantidad.text.toString().toFloat()
                if (rbdCel.isChecked){
                    var celcius : Float = 0.0f
                    celcius =( cantidad*9/5)+32;
                    txtResultado.text = celcius.toString()
                }
                if (rbdCel.isChecked){
                    var celcius : Float = 0.0f
                    celcius =( cantidad 32)*5/9;
                    txtResultado.text = Fahrenheint.toString()
                }
            })
        }
        btnLimpiar.setOnClickListener {
            txtResultado.text = ""
            txtCantidad.text.clear()
            txtResultado.text.clear()
        }
        btnCerrar.setOnClickListener(View.onClickListener{
            finish()
        })






    }