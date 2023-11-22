package com.AngelB6.appalmacenamiento

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.editTextNombreCon)
        val datos = findViewById<EditText>(R.id.editTextTextMultiLineDatos)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        val guardar = findViewById<Button>(R.id.buttonGuardar)
//        Preferences se utiliza para almacenar un cantidad de datos no muy extensa
        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)

        guardar.setOnClickListener{
            val editor = preferencias.edit()
            editor.putString(nombre.text.toString(), datos.text.toString())
            editor.commit()
            Toast.makeText(this, "Se registro el contacto", Toast.LENGTH_LONG).show()
            nombre.setText("")
            datos.setText("")
        }

        consultar.setOnClickListener{
            val datosConsultados = preferencias.getString(nombre.text.toString(), "")
            if (datosConsultados !=null){
                if (datosConsultados.length==0){
                    Toast.makeText(this, "No existe el contacto",Toast.LENGTH_LONG).show()
                }else{
                    datos.setText(datosConsultados)
                }
            }
        }
    }
}