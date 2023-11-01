package com.AngelB6.poo2687391.POOHerencia

open class Persona (val nombre: String, val edad:Int){
    open fun imprimir(){
        println("Nombre: ${nombre}")
        println("Edad: ${edad}")
    }
}