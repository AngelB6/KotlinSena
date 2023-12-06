package com.AngelB6.apptiendabd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class ListaProductos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)

        val viewProductos = findViewById<TextView>(R.id.textViewListaProd)
        val buttonVolver = findViewById<Button>(R.id.buttonVolver)

        val adminBD = AdminSQL(this, "Tienda", null, 1)
        val sql = adminBD.readableDatabase.rawQuery("Select * From producto", null)

        if (sql != null && sql.moveToFirst()){
            val productos = StringBuilder()
            do{
                val nombreProd = sql.getString(sql.getColumnIndex("nombre"))
                val precioProd = sql.getString(sql.getColumnIndex("precio"))
                productos.append("* Nombre: ${nombreProd} - Precio: $${precioProd}\n")
                productos.append("\n")
            } while (sql.moveToNext())
            viewProductos.text = productos.toString()
        }else{
            viewProductos.text = "No hay productos resgitrados"
        }
        sql.close()
        buttonVolver.setOnClickListener{
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }
    }
}