package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val num1 = findViewById<EditText>(R.id.editTextTextNum1)
        val num2 = findViewById<EditText>(R.id.editTextTextNum2)
        val textResultado = findViewById<TextView>(R.id.textViewResultado)
        val botonSuma = findViewById<Button>(R.id.buttonSumar)

        botonSuma.setOnClickListener(){
            var resultado = num1.text.toString().toDouble() + num2.text.toString().toDouble()
//            textResultado.text = "Resultado"
            textResultado.setText("Resultado: ${resultado.toString()}")
            val intento = Intent(this, Calculadora::class.java)
            startActivity(intento)
        }
    }
}