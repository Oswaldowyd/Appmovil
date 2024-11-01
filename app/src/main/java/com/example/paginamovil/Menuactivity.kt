package com.example.paginamovil

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menuactivity : AppCompatActivity() {
    private lateinit var crvHola :CardView
    private lateinit var crvImc :CardView
    private lateinit var crvGrados :CardView
    private lateinit var crvMoneda :CardView
    private lateinit var crvCotizacion :CardView
    private lateinit var crvSalir :CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menuactivity)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        crvHola = findViewById(R.id.crvHola) as CardView
        crvImc = findViewById(R.id.crvImc) as CardView
        crvGrados = findViewById(R.id.crvConvertir) as CardView
        crvMoneda = findViewById(R.id.crvMoneda) as CardView
        crvCotizacion = findViewById(R.id.crvCotizacion) as CardView
        crvSalir = findViewById(R.id.crvSalir) as CardView
    }
    fun eventosClic(){
        crvHola.setOnClickListener(View.OnClickListener {
            val intent = Intent(packageName:this,MainActivity::class.java)
       startActivity(intent) })
    }
}