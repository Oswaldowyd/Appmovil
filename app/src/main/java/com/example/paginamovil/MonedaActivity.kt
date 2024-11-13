package com.example.paginamovil

import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MonedaActivity : AppCompatActivity() {
    private lateinit var txtCantidad: EditText
    private lateinit var spnConversion: Spinner
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_moneda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun inicarComponectes() {
        txtCantidad = findViewById(R.id.txtMoneda) as EditText
        spnConversion = findViewById(R.id.spnConversion) as Spinner
        btnCerrar = findViewById(R.id.btnCerrar) as Button
        btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        btnCalcular = findViewById(R.id.btnCalcular) as Button
        txtResultado = findViewById(R.id.txtResultado) as TextView

        //llenar el spinner con fuente de datos mediante un adaptador

        val items = resources.getStringArray(R.array.array_conversiones)
        val adapter = ArrayAdapter(
            context = this,
            android.R.layout.simple_spinner_item, items
        )
        spnConversion.adapter = adapter

    }

    public fun eventosClic() {
        var pos: Int = 0

        spnConversion.onItemSelectedListener = object
            : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    applicationContext, text"Seleccionastes $item",
                    Toast.LENGTH_SHORT
                ).show()

                pos = position
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnCalcular.setOnClickListener(View.OnClickListener {
            // valores de las monedas
            val dolara = resources.getString(R.string.dolara).toFloat()
            val dolarc = resources.getString(R.string.dolarc).toFloat()
            val euro = resources.getString(R.string.euro).toFloat()
            // validar la cantidad
            if (txtCantidad.text.toString().contentEquals(other ""){
                Toast,makeText(
                    applicationContext,
                   text "Falto capturar la cantidad", Toast.LENGHT_SHORT
                ).show()
                }
                else{

                    var resultado :Float = 0.0f
                var cantidad : Float = 0.0f
                cantidad = txtCantidad.text
                resultado = when (pos){
                    0 -> cantidad / dolara
                    1 -> cantidad / dolarc
                    2 -> cantidad / euro
                    3 -> cantidad * dolara
                    4 -> cantidad * dolarc
                    5 -> cantidad * euro
                    else -> 0.0f
                }
            }

            )
        })
    }
}