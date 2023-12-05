package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Retirar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retirar)

        val textRetValor = findViewById<EditText>(R.id.editTextValorRet)
        val buttonRetirar = findViewById<Button>(R.id.buttonRetirar)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        buttonRetirar.setOnClickListener {
            var retiroString = textRetValor.text.toString()
            if (retiroString.isNotEmpty()) {
                val retiroFinal = retiroString.toLong()
                if (retiroFinal <= AuxiliarSaldo.obtenerSaldo()) {
                    var saldoFinal = AuxiliarSaldo.obtenerSaldo() - retiroFinal
                    AuxiliarSaldo.nuevoSaldo(saldoFinal)
                    Toast.makeText(this, "Trasnferencia realizada:))", Toast.LENGTH_LONG).show()
                    var volverMenuNequi = Intent(this, MenuNequi::class.java)
                    startActivity(volverMenuNequi)
                }else{
                    Toast.makeText(this, "No cuenta con saldo suficiente", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Debe ingresar un valor valido", Toast.LENGTH_LONG).show()
            }
        }

        buttonVolver.setOnClickListener{
            var volver = Intent(this, MenuNequi::class.java)
            startActivity(volver)
        }
    }
}