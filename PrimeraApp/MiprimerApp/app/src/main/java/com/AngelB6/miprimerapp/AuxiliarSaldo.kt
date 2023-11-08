package com.AngelB6.miprimerapp

object AuxiliarSaldo {
    var saldo : Long = 0L

    fun obtenerSaldo(): Long{
        return saldo
    }

    fun nuevoSaldo(nuevoSaldo: Long){
        saldo = nuevoSaldo
    }
}