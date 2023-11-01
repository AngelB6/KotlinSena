package com.AngelB6.poo2687391.POOHerencia

class Empleado(nombre:String, edad:Int, val sueldo:Double): Persona(nombre, edad){
    override fun imprimir() {
        super.imprimir()
        println("Sueldo: $sueldo")
    }

    fun impuesto(){
        if (sueldo > 5000000) {
            println("Debe pagar impuestos")
        }else{
            println("No debe pagar impuestos")
        }
    }
}