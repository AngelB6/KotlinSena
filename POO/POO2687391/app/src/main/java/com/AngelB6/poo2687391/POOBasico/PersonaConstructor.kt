package com.AngelB6.poo2687391.POOBasico

class PersonaConstructor constructor(nombre:String, edad:Int){
    var nombre: String = nombre
    var edad: Int = edad

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