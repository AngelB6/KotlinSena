package com.AngelB6.tienda

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val codigo = findViewById<EditText>(R.id.editTextTextCodProd)
        val nombre = findViewById<EditText>(R.id.editTextTextNomProd)
        val precio = findViewById<EditText>(R.id.editTextTextPrecioProd)
        val registrar = findViewById<Button>(R.id.buttonRegistrar)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        val eliminar = findViewById<Button>(R.id.buttonEliminar)

        registrar.setOnClickListener{
            val adminBD = AdminSQL(this, "MiTienda", null, 1)
            val bd = adminBD.writableDatabase
            val registro = ContentValues()
            registro.put("codigo",codigo.text.toString().toInt())
            registro.put("nombre", nombre.text.toString())
            registro.put("precio", precio.text.toString().toInt())
            bd.insert("producto", null,registro)
            bd.close()
            codigo.setText("")
            nombre.setText("")
            precio.setText("")
            Toast.makeText(this, "!Producto Registrado", Toast.LENGTH_LONG).show()
        }

        consultar.setOnClickListener{
            val adminBD = AdminSQL(this, "Mi Tienda", null, 1)
            val bd = adminBD.writableDatabase
            val consulta = bd.rawQuery("Select nombre, precio From producto Where codigo=${codigo.text.toString()}", null)
            if (consulta.moveToFirst()){
                nombre.setText(consulta.getString(0))
                precio.setText(consulta.getString(1))
            }else{
                Toast.makeText(this, "Producto NO encontrado", Toast.LENGTH_LONG).show()
            }
            bd.close()
        }
    }
}