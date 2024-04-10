package com.example.backend2024grupo_9.domain

import java.time.LocalDateTime

 class Funcion(val fecha : LocalDateTime, var espectaculo: Espectaculo) :Entidad(){

     var entradasVendidas: MutableList<Entrada> = mutableListOf()

    fun entradas(espectaculo: Espectaculo){
        espectaculo.lugar.capacidadTotal()
    }
     fun añadirEntradaVendida(entrada: Entrada) = entradasVendidas.add(entrada)

    fun entradasVendidasPorSector() = entradasVendidas.groupBy { it.sector }

     // te agrupa las la cantidad de entradas compradas por sector
     fun entradasVendidasPorSectorConteo() = entradasVendidas.groupBy { it.sector }.mapValues { it.value.size }

     fun cantidadDeEntradasVendidasPorSector() = entradasVendidasPorSector().map { it.value.count() }

    fun entradaSectorDisponible(entrada: Entrada)  = cantidadDeEntradasVendidasPorSector().sum()

    fun verificarDisponibilidadDeEntrada(entrada: Entrada){
    }

     override fun validar() {
         TODO("Not yet implemented")
     }


 }