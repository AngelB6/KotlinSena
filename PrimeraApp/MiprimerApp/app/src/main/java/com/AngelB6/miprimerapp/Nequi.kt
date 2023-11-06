package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Nequi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nequi)

        var numerosReg = mutableListOf<Long>(3112310715, 3138648830)

        val editTextNum = findViewById<EditText>(R.id.editTextTextNumero)

        val buttonVolver = findViewById<Button>(R.id.buttonVolver)
        val buttonIngresar = findViewById<Button>(R.id.buttonIngresar)

        buttonIngresar.setOnClickListener {
            val numero = editTextNum.text.toString().toLong()
            if (numerosReg.contains(numero)){
                Toast.makeText(this, "Usted ha iniciado sesion correctamente", Toast.LENGTH_LONG).show()
                val ingreso = Intent(this, MenuNequi::class.java)
                startActivity(ingreso)
//                Enrutaje correcto el anterior esta de manera provisional
//                val ingreso = Intent(this, Saldo::class.java)
//                startActivity(ingreso)
            }else{
                Toast.makeText(this, "Los datos ingresados no son validos", Toast.LENGTH_LONG).show()
            }
        }

        buttonVolver.setOnClickListener{
            val volver = Intent(this, Menu::class.java)
            startActivity(volver)
        }
    }
}