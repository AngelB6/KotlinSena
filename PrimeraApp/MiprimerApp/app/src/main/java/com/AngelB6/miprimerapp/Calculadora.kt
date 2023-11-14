package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

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
            val numero1 = num1.text.toString()
            val numero2 = num2.text.toString()

            if (numero1 == "" || numero2 == ""){
                Toast.makeText(this, "El valor no puede estar vacio", Toast.LENGTH_LONG).show()
            }else {
                var resultado = numero1.toDouble() + numero2.toDouble()
                textResultado.setText("Resultado: ${resultado.toString()}")
            }
        }

        buttonRestar.setOnClickListener{
            val numero1 = num1.text.toString()
            val numero2 = num2.text.toString()

            if (numero1 == "" || numero2 == ""){
                Toast.makeText(this, "El valor no puede estar vacio", Toast.LENGTH_LONG).show()
            }else {
                var resultado = numero1.toDouble() - numero2.toDouble()
                textResultado.setText("Resultado: ${resultado.toString()}")
            }
        }

        buttonMultiplicar.setOnClickListener{
            val numero1 = num1.text.toString()
            val numero2 = num2.text.toString()

            if (numero1 == "" || numero2 == ""){
                Toast.makeText(this, "El valor no puede estar vacio", Toast.LENGTH_LONG).show()
            }else {
                var resultado = numero1.toDouble() * numero2.toDouble()
                textResultado.setText("Resultado: ${resultado.toString()}")
            }
        }

        buttonDividir.setOnClickListener{
            val numero1 = num1.text.toString()
            val numero2 = num2.text.toString()

            if (numero1 == "" || numero2 == ""){
                Toast.makeText(this, "El valor no puede estar vacio", Toast.LENGTH_LONG).show()
            }else {
                var resultado = numero1.toDouble() / numero2.toDouble()
                textResultado.setText("Resultado: ${resultado.toString()}")
            }
        }

        buttonVolver.setOnClickListener{
            val volver = Intent(this, Menu::class.java)
            startActivity(volver)
        }
    }
}