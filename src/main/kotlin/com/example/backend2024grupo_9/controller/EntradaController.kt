package com.example.backend2024grupo_9.controller

import com.example.backend2024grupo_9.domain.Entrada
import com.example.backend2024grupo_9.servicios.EntradaService
import com.example.backend2024grupo_9.servicios.EspectaculoService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin("*")
class EntradaController (@Autowired val entradaService : EntradaService) {

    @GetMapping("/Entrada")
    fun getEspectaculo() = entradaService.getEntrada()

    @GetMapping("/Entrada/{id}")
    @Operation(summary = "Devuelve una entrada por id")
    fun getEntrada(@PathVariable id: Int) = entradaService.getEntrada(id)

    @GetMapping("/Entrada/espectaculo/{id}")
    @Operation(summary = "Devuelve el valor de la entrada")
    fun getEntrada3(@PathVariable id: Int) : List<Entrada> {
        val entrada = entradaService.getEspectaculo(id)
        return entrada
    }





}