package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val buttonNequi = findViewById<Button>(R.id.buttonNequi)
        val buttonLibre = findViewById<Button>(R.id.buttonLibre)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        buttonCalculadora.setOnClickListener{
            val calculadora = Intent(this, Calculadora::class.java)
            startActivity(calculadora)
        }

        buttonNequi.setOnClickListener{
            val nequi = Intent(this, Nequi::class.java)
            startActivity(nequi)
        }

        buttonLibre.setOnClickListener{
            val libre = Intent(this, Libre::class.java)
            startActivity(libre)
        }

        buttonVolver.setOnClickListener{
            val volver = Intent(this, MainActivity::class.java)
            startActivity(volver)
        }
    }
}