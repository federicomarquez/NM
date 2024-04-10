package com.example.backend2024grupo_9.domain
import org.uqbar.geodds.Point


class Ubicacion(val ubicacion: Point = Point(0,0)) {

    fun obtenerCoordenadaX(): Double {
        return ubicacion.x
    }
    fun obtenerCoordenadaY(): Double {
        return ubicacion.y
    }
}

