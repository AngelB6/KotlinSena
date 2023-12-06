package com.AngelB6.apptiendabd

import android.content.Intent
import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.contentValuesOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val codigo = findViewById<EditText>(R.id.editTextTextCodProd)
        val nombre = findViewById<EditText>(R.id.editTextTextNomProd)
        val precio = findViewById<EditText>(R.id.editTextTextPrecioProd)
        val registrar = findViewById<Button>(R.id.buttonRegistrar)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        val editar = findViewById<Button>(R.id.buttonEditar)
        val eliminar = findViewById<Button>(R.id.buttonEliminar)
        val listaProd = findViewById<Button>(R.id.buttonListaProd)

        registrar.setOnClickListener{
            val adminBD = AdminSQL(this, "Tienda", null, 1);
            val bd = adminBD.writableDatabase
            val registro = contentValuesOf()
            registro.put("codigo",codigo.text.toString().toInt())
            registro.put("nombre", nombre.text.toString())
            registro.put("precio", precio.text.toString().toFloat())
            val insercion = bd.insert("producto", null,registro)
            bd.close()
            if (insercion.toInt() == -1){
                Toast.makeText(this, "El id ${codigo.text.toString()} ya le pertenece a un producto", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Producto Registrado!", Toast.LENGTH_LONG).show()
                codigo.setText("")
                nombre.setText("")
                precio.setText("")
            }
        }

        consultar.setOnClickListener{
                val adminBD = AdminSQL(this, "Tienda", null, 1)
                val bd = adminBD.writableDatabase
                val consulta = bd.rawQuery("select nombre, precio From producto Where codigo = ${codigo.text.toString()}", null)

                if (consulta.moveToFirst()) {
                    nombre.setText(consulta.getString(0))
                    precio.setText(consulta.getString(1))
                } else {
                    Toast.makeText(this, "Producto NO encontrado", Toast.LENGTH_LONG).show()
                    nombre.setText("")
                    precio.setText("")
                }
                bd.close()
        }

        editar.setOnClickListener{
            val adminBD = AdminSQL(this, "Tienda", null, 1);
            val bd = adminBD.writableDatabase
            val editar = contentValuesOf()
            editar.put("nombre", nombre.text.toString())
            editar.put("precio", precio.text.toString().toFloat())
            val edicion = bd.update("producto", editar, "codigo = ${codigo.text.toString()}", null)
            bd.close()
            if (edicion == 1){
                Toast.makeText(this, "Producto actualizado con exito!", Toast.LENGTH_LONG).show()
                codigo.setText("")
                nombre.setText("")
                precio.setText("")
            }else{
                Toast.makeText(this, "Producto no encontrado", Toast.LENGTH_LONG).show()
            }
        }

        eliminar.setOnClickListener{
            val adminBD = AdminSQL(this, "Tienda", null, 1);
            val bd = adminBD.writableDatabase
            val eliminar = bd.delete("producto", "codigo = ${codigo.text.toString()}", null)
            bd.close()
            if (eliminar == 1){
                Toast.makeText(this, "Producto eliminado con exito!", Toast.LENGTH_LONG).show()
                codigo.setText("")
                nombre.setText("")
                precio.setText("")
            }else{
                Toast.makeText(this, "Producto no encontrado", Toast.LENGTH_LONG).show()
            }
        }

        listaProd.setOnClickListener {
            val intent = Intent(this, ListaProductos::class.java)
            startActivity(intent)
        }
    }
}