package com.AngelB6.miprimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Consignar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consignar)

        val textSaldo = findViewById<EditText>(R.id.editTextValorCon)
        val buttonEnviar = findViewById<Button>(R.id.buttonEnviar)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        buttonEnviar.setOnClickListener{
            var consignaccion = textSaldo.text.toString().toLong()
            if (consignaccion != null){
                var saldoFinal = AuxiliarSaldo.obtenerSaldo() + consignaccion
                AuxiliarSaldo.nuevoSaldo(saldoFinal)
                Toast.makeText(this, "Trasnferencia realizada:))", Toast.LENGTH_LONG).show()
                var volverMenuNequi = Intent(this, MenuNequi::class.java)
                startActivity(volverMenuNequi)
            }else{
                Toast.makeText(this, "Ingresa un valor valido", Toast.LENGTH_LONG).show()
            }
        }

        buttonVolver.setOnClickListener{
            val volver = Intent(this, MenuNequi::class.java)
            startActivity(volver)
        }
    }
}