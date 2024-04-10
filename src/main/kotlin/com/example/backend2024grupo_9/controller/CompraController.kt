package com.example.backend2024grupo_9.controller

import com.example.backend2024grupo_9.DTO.CompraDTO
import com.example.backend2024grupo_9.domain.Funcion
import com.example.backend2024grupo_9.servicios.EntradaService
import com.example.backend2024grupo_9.servicios.EspectaculoService
import com.example.backend2024grupo_9.servicios.FuncionService
import com.example.backend2024grupo_9.servicios.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class CompraController(
    @Autowired val entradaService: EntradaService,
    @Autowired val espectaculoService: EspectaculoService,
    @Autowired val usuarioService: UsuarioService,
    @Autowired val funcionService: FuncionService
) {

 //@Transactional(  )
    @PostMapping("/Compra")
    @Operation(summary = "Se genera una compra")
    fun comprarEntradas(@RequestBody compra: CompraDTO): List<Funcion> {
        val usuario = usuarioService.getUser(compra.usuarioId)
        val funcionesID= compra.entradas.map{ it.idFuncion }.distinct()

        return  funcionService.getByIdFuncion(funcionesID)
    }

}