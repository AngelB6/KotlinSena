package com.AngelB6.poo2687391.POOBasico

class Persona {
    var nombre: String = ""
    var edad: Int = 0

    fun inicializar(nombre:String, edad:Int){
        this.nombre = nombre
        this.edad = edad
    }

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

    fun captuData(){
        println("Por favor ingrese su nombre:")
        nombre = readLine().toString()
        println("Por favor ingrese su edad:")
        edad = readLine()!!.toInt()
    }
}