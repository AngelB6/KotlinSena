package com.AngelB6.apptiendabd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class AdminSQL(contexto: Context, nombre: String, cursor: CursorFactory?, version: Int):
    SQLiteOpenHelper(contexto, nombre, cursor, version){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("Create table producto (codigo int primary key, nombre text, precio real)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}