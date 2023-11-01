package com.AngelB6.poo2687391.ExpresionesLambda

fun operar(numero1: Double, numero2: Double, fn:(Double, Double)->Double):Double{
    return  fn(numero1, numero2)
}

fun main() {
    val resultadoSuma = operar(5.0,4.0,{num1,num2-> num1+num2})
    println(resultadoSuma)
    val resultadoResta = operar(5.0,4.0,{num1,num2-> num1-num2})
    println(resultadoResta)
}