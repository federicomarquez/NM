package com.example.backend2024grupo_9.controller

import com.example.backend2024grupo_9.servicios.FuncionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin("*")

class FuncionController(
    @Autowired val funcionService: FuncionService


) {

    @GetMapping("/Funcion")
    fun getFuncion() = funcionService.getFunciones()








}