package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Salir : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salir)

        val buttonSalir = findViewById<Button>(R.id.buttonSi)
        val buttonNoSalir = findViewById<Button>(R.id.buttonNo)

        buttonSalir.setOnClickListener{
            Toast.makeText(this, "Hasta luego:))", Toast.LENGTH_LONG).show()
            finishAffinity()
        }

        buttonNoSalir.setOnClickListener{
            val noSalir = Intent(this, MenuNequi::class.java)
            startActivity(noSalir)
        }
    }
}