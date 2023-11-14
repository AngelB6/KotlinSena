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

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val buttonSaludar = findViewById<Button>(R.id.buttonSaludar)
        val buttonSalir = findViewById<Button>(R.id.buttonSalir)

        buttonSaludar.setOnClickListener{
            var nombreRecogido = editTextNombre.text.toString()
            Toast.makeText(this, "Bienvenido ${nombreRecogido} a mi APP!", Toast.LENGTH_LONG).show()
            val menu = Intent(this, Menu::class.java)
            startActivity(menu)
        }

        buttonSalir.setOnClickListener{
            finishAffinity()
            Toast.makeText(this, "Hasta luego:))", Toast.LENGTH_LONG).show()
        }
    }
}