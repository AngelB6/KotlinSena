package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AdivinaNum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivina_num)

        val numeroIng = findViewById<TextView>(R.id.textViewAdivinaNum)
        val mostrarRe = findViewById<TextView>(R.id.textViewMayorMenor)
        val buttonAdivinar = findViewById<Button>(R.id.buttonResultado)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        buttonAdivinar.setOnClickListener{
            val numeroGenerado = (1..20).random()
            val numeroFinal = numeroIng.text.toString().toInt()
            println(numeroGenerado)
            if (numeroFinal < numeroGenerado){
                mostrarRe.setText("Es menor a ${numeroFinal.toString()}")
            }else if(numeroFinal > numeroGenerado){
                mostrarRe.setText("Es mayor a ${numeroFinal.toString()}")
            }else if(numeroFinal == numeroGenerado){
                mostrarRe.setText("Correcto, ${numeroFinal.toString()} es el numero. Felicidades!")
            }else{
                mostrarRe.setText("${numeroFinal.toString()} no es un numero valido")
            }
        }

        buttonVolver.setOnClickListener{
            val intento = Intent(this, Menu::class.java)
            startActivity(intento)
        }
    }
}