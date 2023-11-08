package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.AngelB6.miprimerapp.AuxiliarSaldo

class ConsultarSaldo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_saldo)

        val viewSaldo = findViewById<TextView>(R.id.textViewSaldoView)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        viewSaldo.setText("$${AuxiliarSaldo.obtenerSaldo()}")

        buttonVolver.setOnClickListener{
            val volver = Intent(this, MenuNequi::class.java)
            startActivity(volver)
        }
    }
}