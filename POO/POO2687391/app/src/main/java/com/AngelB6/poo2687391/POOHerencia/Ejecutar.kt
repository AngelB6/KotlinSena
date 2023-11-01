package com.AngelB6.poo2687391.POOHerencia

fun main() {
    val persona = Persona("Felipe", 30)
    persona.imprimir()
    val empleado = Empleado("Pepe",50, 60000000.0)
    empleado.imprimir()
    empleado.impuesto()
    val empleado2 = Empleado("Pepe",50, 60000000.0)
    empleado2.imprimir()
    empleado2.impuesto()
}