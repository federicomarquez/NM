package com.example.backend2024grupo_9.domain

abstract class Entidad {
    var id: Int = 0
    var activo : Boolean = true

    fun esNuevo() = id == 0
    abstract  fun validar()

    fun desactivar() {
        this.activo = false
    }


}