package com.AngelB6.poo2687391.POOColaboracion

class Cliente (var nombre:String, var saldoCuenta:Float){

    fun consignar(valor:Float){
        this.saldoCuenta += valor
    }

    fun retirar(valor: Float){
        this.saldoCuenta -= valor
    }

    fun imprimir(){
        println("${nombre} usted tiene un saldo en su cuenta ${saldoCuenta}")
    }
}