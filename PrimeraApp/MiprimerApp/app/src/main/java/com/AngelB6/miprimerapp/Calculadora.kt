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
        val buttonSumar = findViewById<Button>(R.id.buttonSumar)
        val buttonRestar = findViewById<Button>(R.id.buttonRestar)
        val buttonMultiplicar = findViewById<Button>(R.id.buttonMultiplicar)
        val buttonDividir = findViewById<Button>(R.id.buttonDividir)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        buttonSumar.setOnClickListener{
            var resultado = num1.text.toString().toDouble() + num2.text.toString().toDouble()
            textResultado.setText("Resultado: ${resultado.toString()}")
        }

        buttonRestar.setOnClickListener{
            var resultado = num1.text.toString().toDouble() - num2.text.toString().toDouble()
            textResultado.setText("Resultado: ${resultado.toString()}")
        }

        buttonMultiplicar.setOnClickListener{
            var resultado = num1.text.toString().toDouble() * num2.text.toString().toDouble()
            textResultado.setText("Resultado: ${resultado.toString()}")
        }

        buttonDividir.setOnClickListener{
            var resultado = num1.text.toString().toDouble() / num2.text.toString().toDouble()
            textResultado.setText("Resultado: ${resultado.toString()}")
        }

        buttonVolver.setOnClickListener{
            val volver = Intent(this, Menu::class.java)
            startActivity(volver)
        }
    }
}