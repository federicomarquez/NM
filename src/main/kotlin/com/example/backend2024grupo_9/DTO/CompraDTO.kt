package com.example.backend2024grupo_9.DTO

import com.example.backend2024grupo_9.domain.Espectaculo
import com.example.backend2024grupo_9.domain.Funcion
import com.example.backend2024grupo_9.domain.Instalacion
import com.example.backend2024grupo_9.domain.Usuario
import jakarta.validation.constraints.Null
import java.time.LocalDate
import java.time.LocalDateTime

data class CompraDTO(val usuarioId: Int, val entradas : List<EntradaDTO> )