package com.AngelB6.poo2687391.BancoPractica

fun main() {
//    Creamos un objeto para ejecutar los metodos
    val Cliente1 = Cliente()
//    Arreglos que almacenaran los datos de los clientes
    var id = mutableListOf<Int>()
    var clientes = mutableListOf<String>()
    var clieDoc = mutableListOf<Int>()
    var saldoClie = mutableListOf<Float>()
//    Variable que alamacenara la respuesta del usuario por si desea salir del sistema
    var rps: String="no"
    var idUsua: Int
//    Bienvenida al sistema y digitacion de clientes
    println("Bienvenido!\nPor favor ingrese la cantidad de clientes que desea registrar:")
    var cliCant:Int = readLine()!!.toInt()
    for (i in 1 .. cliCant){
        println("Por favor ingrese el nombre del cliente N${i}:")
        var nomClie: String = readLine().toString()
        clientes.add(nomClie)
        println("Por favor ingrese el numero de documento del cliente ${nomClie}:")
        var numClie: Int = readLine()!!.toInt()
        clieDoc.add(numClie)
        println("Por favor ingrese el saldo del cliente ${nomClie}:")
        var saldo: Float = readLine()!!.toFloat()
        saldoClie.add(saldo)
        println("${nomClie} su id de ususario es: ${i}")
        id.add(i-1)
    }
    println("Se han resgistrado los clientes con exito.")
//    Menu
    do {
        println("¿Que desea hacer?\n1. Consignar\n2. Retirar\n3. Consultar Saldo\n4. Salir")
        var seleccion:Int = readLine()!!.toInt()
        when (seleccion){
            1 ->{
                println("Usted selecciono la opcion consignar\nPor favor ingrese su ID de usuario:")
                idUsua = readLine()!!.toInt()
                idUsua-=1
                if (idUsua == id[idUsua]) {
                    println("Bienvenido ${clientes[idUsua]}\nSu numero de documento es: ${clieDoc[idUsua]} y su saldo es ${saldoClie[idUsua]}")
                    saldoClie[idUsua]=Cliente1.consignar(saldoClie[idUsua])
                    println("Trasaccion finalizada\nSu saldo final es: ${saldoClie[idUsua]}")
                }else{
                    println("Su ID de usuario no fue encontrado. Por favor vuelva a intentarlo")
                }
            }
            2 ->{
                println("Usted selecciono la opcion retirar\nPor favor ingrese su ID de usuario:")
                idUsua = readLine()!!.toInt()
                idUsua-=1
                if (idUsua == id[idUsua]) {
                    println("Bienvenido ${clientes[idUsua]}\nSu numero de documento es: ${clieDoc[idUsua]} y su saldo es ${saldoClie[idUsua]}")
                    saldoClie[idUsua]= Cliente1.retirar(saldoClie[idUsua])!!
                    println("Trasaccion finalizada\nSu saldo final es: ${saldoClie[idUsua]}")
                }else{
                    println("Su ID de usuario no fue encontrado. Por favor vuelva a intentarlo")
                }
            }
            3 ->{
                println("Usted seleccion la opcion consultar saldo\nPor favor ingrese su ID de usuario:")
                idUsua = readLine()!!.toInt()
                idUsua-=1
                if (idUsua == id[idUsua]) {
                    println("Bienvenido ${clientes[idUsua]}\nSu numero de documento es: ${clieDoc[idUsua]} y su saldo es ${saldoClie[idUsua]}")
                }else{
                    println("Su ID de usuario no fue encontrado. Por favor vuelva a intentarlo")
                }
            }
            4 ->{
                println("Usted selecciono la opcion salir\n¿Seguro desea salir? (Si - No)")
                rps = readLine().toString().lowercase()
                val total = saldoClie.sum()
                println("La suma de los saldos de las cuentas resgitradas son: ${total}")
                break
            }
            else -> println("Ingreso una opcion incorrecta. Por favor vuelva a intentarlo.")
        }
        println("¿Desea salir? (Si - No)")
        rps = readLine().toString().lowercase()
    }while (rps=="no")
}