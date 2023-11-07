package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuNequi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_nequi)

        val buttonSalir = findViewById<Button>(R.id.buttonSalir)

        buttonSalir.setOnClickListener{
            val salir = Intent(this, Salir::class.java)
            startActivity(salir)
        }
    }
}