package com.example.backend2024grupo_9.domain

abstract class Instalacion(
    val nombre: String = "",
    val ubicacion: Ubicacion,
    val costo: Int = 1,
    val sectores : Map<Sector,Int>
) : Entidad() {

    abstract fun costo() :Int


    fun capacidadTotal() :Int = sectores.values.sum()

    override fun validar() {
        TODO("Not yet implemented")
    }
}


class Estadio(
    nombre: String,
    ubicacion: Ubicacion = Ubicacion(org.uqbar.geodds.Point(-34.66128, -58.36713)),
    costo: Int,
    capacidadPalco: Int = 10,
    capacidadPlateaAlta: Int = 10,
    capacidadCampo: Int = 10
) : Instalacion(nombre, ubicacion, costo, sectores= mapOf(Palco to capacidadPalco, PlateaAlta to capacidadPlateaAlta,Campo to capacidadCampo)) {

    override fun costo() = this.costo


}


class Teatro(
    nombre: String,
    ubicacion: Ubicacion,
    costo: Int = 100000,
    val buenaAcustica: Boolean = false,
    capacidadPullman: Int = 10,
    capacidadPlateaBaja: Int = 10
) : Instalacion(nombre, ubicacion, costo, sectores= mapOf(PlateaBaja to PlateaBaja.valorDeLocacion(),Pullman to capacidadPullman)) {

    companion object{
    val FACTOR_BUENA_ACUSTICA = 50000
    val SIN_FACTOR = 0
}


    fun factorBuenaAcustina () = if(buenaAcustica) FACTOR_BUENA_ACUSTICA else SIN_FACTOR

    override fun costo(): Int = this.costo + factorBuenaAcustina()





}