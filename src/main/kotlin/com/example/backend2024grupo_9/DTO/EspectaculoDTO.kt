package com.example.backend2024grupo_9.DTO

import com.example.backend2024grupo_9.domain.Espectaculo
import com.example.backend2024grupo_9.domain.Funcion
import com.example.backend2024grupo_9.domain.Instalacion
import com.example.backend2024grupo_9.domain.Usuario
import jakarta.validation.constraints.Null
import java.time.LocalDate
import java.time.LocalDateTime

data class EspectaculoDTO(val banda: String ,
                          val lugar: Int ,
                          val gira: String ,
                          val costoBanda: Int,
                          val fechas : MutableList<Funcion>)


fun EspectaculoDTO.toEspectaculo(instalacion : Instalacion) = Espectaculo(banda = banda,
    lugar = instalacion,
    gira = gira,
    costoBanda = 10,
   fechas = fechas
)
// se va
data class CompraDTO(val usuarioId: Int, val entradas : List<EntradaDTO> )


data class EntradaDTO(val id: Int,
                      val cantidad: Int ,
                      val sector :String
)
