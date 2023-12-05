package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AdivinaNum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivina_num)

        val numeroIng = findViewById<EditText>(R.id.editTextNumberNum)
        val mostrarRe = findViewById<TextView>(R.id.textViewMayorMenor)
        val buttonAdivinar = findViewById<Button>(R.id.buttonAdivinar)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        val numeroGenerado = (1..20).random()

        buttonAdivinar.setOnClickListener{
            val numeroFinal = numeroIng.text.toString()
            println(numeroGenerado)
            if (!numeroFinal.isNullOrEmpty()){
                if (numeroFinal.toInt() < numeroGenerado && numeroFinal.toInt() <= 20){
                    mostrarRe.setText("Es mayor a ${numeroFinal.toString()}")
                }else if(numeroFinal.toInt() > numeroGenerado && numeroFinal.toInt() <= 20){
                    mostrarRe.setText("Es menor a ${numeroFinal.toString()}")
                }else if(numeroFinal.toInt() === numeroGenerado){
                    mostrarRe.setText("Correcto, ${numeroFinal.toString()} es el numero. Felicidades!")
                }else{
                    mostrarRe.setText("${numeroFinal.toString()} no es un numero valido.\nRecuerde es 1 a 20.")
                }
            }else{
                Toast.makeText(this, "El valor no puede estar vacio",Toast.LENGTH_LONG).show()
            }
        }

        buttonVolver.setOnClickListener{
            val intento = Intent(this, Menu::class.java)
            startActivity(intento)
        }
    }
}