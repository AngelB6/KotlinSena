package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val botonSaludar = findViewById<Button>(R.id.Saludar)
        botonSaludar.setOnClickListener{
            var nombreRecogido = nombre.text.toString()
            Toast.makeText(this, "Bienvenido ${nombreRecogido} a mi APP!", Toast.LENGTH_LONG).show()
            val intento = Intent(this, Calculadora::class.java)
            startActivity(intento)
        }
    }
}