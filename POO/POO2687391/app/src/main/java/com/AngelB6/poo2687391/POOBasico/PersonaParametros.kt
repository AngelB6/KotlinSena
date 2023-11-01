package com.AngelB6.poo2687391.POOBasico

class PersonaParametros (var nombre:String, var edad:Int){
    fun imprimir(){
        println("Nombre: ${nombre} y edad: ${edad}")
    }

    fun mayorEdad(){
        if (edad >= 18){
            println("${nombre} usted es mayor de edad. Usted puede ingresar.")
        }else{
            println("${nombre} usted es menor de edad. No puede ingresar.")
        }
    }
}