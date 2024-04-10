package com.example.backend2024grupo_9.domain

import java.time.LocalDate

class Entrada(
    var numero: Int=1,
    val fechaDeEvento: LocalDate = LocalDate.now(), // funcion.fecha
    val espectaculo: Espectaculo,
    val sector : Sector = Pullman,
    val nombreSector : String = sector.toString(),
    var precio : Double= ((espectaculo.costoAdicionalPorCapacidad()  + sector.valorDeLocacion() ) * espectaculo.rentabilidadActual())
) :
    Entidad() {


    fun precioDeEntrada() :Double = (espectaculo.costoAdicionalPorCapacidad()  + sector.valorDeLocacion() ) * espectaculo.rentabilidadActual()


    fun esSaldoValido() : Boolean = numero >=0
    fun esValidaFechaDeEvento(): Boolean = fechaDeEvento.isBefore(LocalDate.now())
    override fun validar() {
        esSaldoValido()
        esValidaFechaDeEvento()
    }

}