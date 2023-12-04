package com.santiagobulla.tiendabd

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

        val codigo = findViewById<EditText>(R.id.editTextId)
        val nombre = findViewById<EditText>(R.id.editTextNombreProducto)
        val precio = findViewById<EditText>(R.id.editTextPrecio)
        val registrar = findViewById<Button>(R.id.buttonRegistrar)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        val editar = findViewById<Button>(R.id.buttonEditar)
        val inactivar = findViewById<Button>(R.id.buttonInactivar)
        val inventario = findViewById<Button>(R.id.buttonInventario)

        inventario.setOnClickListener {
            val intent = Intent(this, ListaProductos::class.java)
            startActivity(intent)
        }

        registrar.setOnClickListener {
            val adminBD = AdminSQL(
                this, "TiendaMaster", null, 1
            );//crear un objeto de la clase con la config de la bd
            val bd = adminBD.writableDatabase
            val registro = contentValuesOf()//objeto con la info
            registro.put("codigo", codigo.text.toString().toInt())
            registro.put("nombre", nombre.text.toString())
            registro.put("precio", precio.text.toString().toFloat())
            val response = bd.insert("producto", null, registro)//hacer la insercion
            bd.close()
            if(response.toInt() == -1){
                Toast.makeText(this, "El id ${codigo.text.toString()} ya se encuentra asociado a un producto", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Producto agregado correctamente", Toast.LENGTH_LONG).show()
                codigo.setText("")
                nombre.setText("")
                precio.setText("")
            }
        }

        consultar.setOnClickListener {
            val adminBD = AdminSQL(this, "TiendaMaster", null, 1);
            val bd = adminBD.writableDatabase
            val consulta = bd.rawQuery(
                "select nombre, precio from producto where codigo = ${codigo.text.toString()}", null
            )
            if (consulta.moveToFirst()) {
                nombre.setText(consulta.getString(0))
                precio.setText(consulta.getString(1))
            } else {
                Toast.makeText(this, "producto no encontrado", Toast.LENGTH_LONG).show()
                nombre.setText("")
                precio.setText("")
            }

            bd.close()
        }

        editar.setOnClickListener {
            val adminBD = AdminSQL(this, "TiendaMaster", null, 1);
            val bd = adminBD.writableDatabase //permite interactuar con la bd
            val registro = contentValuesOf()//objeto con la info
            registro.put("nombre", nombre.text.toString())
            registro.put("precio", precio.text.toString().toFloat())
            var response = bd.update(
                "producto", registro, "codigo = ${codigo.text.toString()}", null
            )//hacer el update
            bd.close()
            codigo.setText("")
            nombre.setText("")
            precio.setText("")
            if (response == 1) {
                Toast.makeText(this, "producto actualizado correctamento", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "producto no encontrado", Toast.LENGTH_LONG).show()
            }
        }

        inactivar.setOnClickListener {
            val adminBD = AdminSQL(this, "TiendaMaster", null, 1);
            val bd = adminBD.writableDatabase //permite interactuar con la bd
            val eliminar = bd.delete("producto", "codigo = ${codigo.text.toString()}", null)
            bd.close()
            codigo.setText("")
            nombre.setText("")
            precio.setText("")
            if (eliminar == 1) {
                Toast.makeText(this, "producto eliminado correctamento", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "producto no encontrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}