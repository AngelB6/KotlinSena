package com.AngelB6.poo2687391.funOrdenSuperior

fun operar(numero1: Double, numero2: Double, fn:(Double, Double)->Double):Double{
    return fn(numero1, numero2)
}
fun sumar(numero1: Double, numero2: Double)=numero1+numero2
fun resta(numero1: Double, numero2: Double)=numero1-numero2

fun main() {
    val resultadoSuma = operar(15.0,5.0,::sumar)
    println(resultadoSuma)
    val resultadoResta = operar(15.0,5.0,::resta)
    println(resultadoResta)
}