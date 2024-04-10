package com.example.backend2024grupo_9.domain

interface Sector {
    fun valorFinal(entrada: Entrada) = entrada.precioDeEntrada()
    fun valorDeLocacion() : Int
    override fun toString() : String
}
object Campo :Sector{
    override fun valorDeLocacion(): Int = 15000
    override fun toString(): String  = "CAMPO"
    override fun valorFinal(entrada: Entrada) = entrada.precioDeEntrada()
}
object Palco :Sector{
    override fun valorDeLocacion(): Int = 20000
    override fun toString(): String  = "PALCO"
}
object PlateaAlta :Sector{
    override fun valorDeLocacion(): Int = 10000
    override fun toString(): String  = "PLATEA ALTA"
}
object PlateaBaja :Sector{
    override fun valorDeLocacion(): Int = 15000
    override fun toString(): String  = "PLATEA BAJA"
}
object Pullman :Sector{
    override fun valorDeLocacion(): Int = 10000
    override fun toString(): String  = "PULLMAN"
}