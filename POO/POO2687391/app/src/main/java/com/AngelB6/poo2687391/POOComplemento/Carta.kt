package com.AngelB6.poo2687391.POOComplemento

class Carta (val tipocarta: DatosCartas, val numeroCarta: Int){
    fun imprimir(){
        println("Carta ${tipocarta} Valor: ${numeroCarta}")
    }
}

fun main() {
    val carta = Carta(DatosCartas.PICA,6)
}