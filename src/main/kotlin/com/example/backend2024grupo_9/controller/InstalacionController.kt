package com.example.backend2024grupo_9.controller

import com.example.backend2024grupo_9.servicios.InstalacionService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin("*")
class InstalacionController (@Autowired val instalacionService : InstalacionService){

    @GetMapping("/Instalacion")
    fun getInstalacion() = instalacionService.getInstalacion()

    @GetMapping("/Instalacion/{id}")
    @Operation(summary = "Devuelve una instalacion por id")
    fun getInstalacion(@PathVariable id: Int) = instalacionService.getInstalacion(id)



}