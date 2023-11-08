package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuNequi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_nequi)

        val buttonConsignar = findViewById<Button>(R.id.buttonConsignar)
        val buttonRetirar = findViewById<Button>(R.id.buttonRetirar)
        val buttonConsultar = findViewById<Button>(R.id.buttonConsultar)
        val buttonSalir = findViewById<Button>(R.id.buttonSalir)

        buttonConsignar.setOnClickListener{
            val consignar = Intent(this, Consignar::class.java)
            startActivity(consignar)
        }

        buttonRetirar.setOnClickListener{
            val retirar = Intent(this, Retirar::class.java)
            startActivity(retirar)
        }

        buttonConsultar.setOnClickListener{
            val consultar = Intent(this, ConsultarSaldo::class.java)
            startActivity(consultar)
        }

        buttonSalir.setOnClickListener{
            val salir = Intent(this, Salir::class.java)
            startActivity(salir)
        }
    }
}