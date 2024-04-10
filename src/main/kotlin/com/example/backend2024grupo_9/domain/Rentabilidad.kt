package com.example.backend2024grupo_9.domain

interface Rentabilidad{

    fun porcentaje() : Double

}

object RentabilidadBaja : Rentabilidad {
    override fun porcentaje(): Double = 0.8

}

object RentabilidadPlena: Rentabilidad {
    override fun porcentaje(): Double = 1.0
}
object RentabilidadMegaShow: Rentabilidad {
    override fun porcentaje(): Double = 1.3

}
