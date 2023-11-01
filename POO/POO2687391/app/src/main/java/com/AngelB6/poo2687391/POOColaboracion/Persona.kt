package com.AngelB6.poo2687391.POOColaboracion

class Persona {
    var nombre: String = ""
        set(valor) {
            field = valor.toUpperCase()
        }
        get() {
            return field
        }
    var edad: Int = 0
        set(valor) {
            if (valor >= 0) {
                field = valor
            } else {
                field = 0
            }
        }
}

fun main() {
    val persona1 = Persona()
    persona1.nombre="Angel"
    persona1.edad=18
    println(persona1.nombre)
    println(persona1.edad)
    persona1.edad=-20
    println(persona1.edad)
}