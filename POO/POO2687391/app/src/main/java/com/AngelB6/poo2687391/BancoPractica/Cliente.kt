package com.AngelB6.poo2687391.BancoPractica

class Cliente {
    fun consignar(saldo: Float): Float {
        println("Ingrese el valor que desea consignar:")
        var cons: Float = readLine()!!.toFloat()
        var saldoFinal = cons + saldo
        return saldoFinal
    }

    fun retirar(saldo: Float): Float {
        var saldoFinal:Float =0f
        println("Ingrese el valor que desea retirar:")
        var cons: Float = readLine()!!.toFloat()
        if (cons <= saldo) {
             saldoFinal = saldo-cons
        }else{
            println("Trasaccion Fallida. Fondos insuficientes.")
            return saldo
        }
        if (saldoFinal != 0f){
            return saldoFinal
        }
        return TODO("Provide the return value")
    }
}