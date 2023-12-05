package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.AngelB6.miprimerapp.AuxiliarSaldo

class Saldo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saldo)

        val buttonRecarga = findViewById<Button>(R.id.buttonRecargar)
        val buttonSalir = findViewById<Button>(R.id.buttonSalir)
        val editTextSaldo = findViewById<EditText>(R.id.editTextSaldo)

        buttonRecarga.setOnClickListener{
            var saldoString = editTextSaldo.text.toString()
            if (saldoString.isNotEmpty()){
                val saldoFinal = saldoString.toLong()
                AuxiliarSaldo.nuevoSaldo(saldoFinal)
                Toast.makeText(this, "Saldo recargado con exito",Toast.LENGTH_LONG).show()
                val ingresoMenu = Intent(this, MenuNequi::class.java)
                ingresoMenu.putExtra("variable", saldoFinal)
                startActivity(ingresoMenu)
            }else{
                Toast.makeText(this, "Ingrese un valor valido", Toast.LENGTH_LONG).show()
            }
        }

        buttonSalir.setOnClickListener{
            val salir = Intent(this, Salir::class.java)
            startActivity(salir)
        }
    }
}