package com.example.backend2024grupo_9.controller

import com.example.backend2024grupo_9.DTO.EspectaculoDTO
import com.example.backend2024grupo_9.DTO.toEspectaculo
import com.example.backend2024grupo_9.domain.Espectaculo
import com.example.backend2024grupo_9.repositorio.RepoEspectaculo
import com.example.backend2024grupo_9.servicios.EspectaculoService
import com.example.backend2024grupo_9.servicios.InstalacionService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.Month


@RestController
@CrossOrigin("*")
class EspectaculoController(
    @Autowired val espectaculoService: EspectaculoService,
    @Autowired val instalacionService: InstalacionService,
    private val repoEspectaculo: RepoEspectaculo
) {


    @GetMapping("/Espectaculo")
    fun getEspectaculo() = espectaculoService.getEspectaculo()

    @GetMapping("/EspectaculosActivos")
    fun getEspectaculoActivos() = espectaculoService.getESpectulosActivos()

    @GetMapping("/Espectaculoss")
    fun getEspetaculo() = EspectaculoDTO("asd",2,"asd", 1200, mutableListOf())

    @GetMapping("/Espectaculo/{id}")
    @Operation(summary = "Devuelve un espectaculo por id")
    fun getEspectaculo(@PathVariable id: Int) = espectaculoService.getEspectaculo(id)

    @PostMapping("/crearEspectaculo")
    @Operation(summary = "crea un espectaculo")
    fun create(@RequestBody espectaculo: Espectaculo) = espectaculoService.create(espectaculo)

    @PostMapping("/crearEspectaculos")
    fun create(@RequestBody espectaculobody : EspectaculoDTO): Espectaculo {
        val instalacionid = instalacionService.getInstalacion(espectaculobody.lugar)
        return espectaculoService.create(espectaculobody.toEspectaculo(instalacionid))
    }

    @DeleteMapping("/deleteEspectaculo/{id}")
    fun delete(@PathVariable id: Int){
        return espectaculoService.delete(id)
    }

    @GetMapping("/Espectaculo/busqueda")
    fun getEspectaculoBusqueda(
        @RequestParam campoDeBusqueda: String? = "",
    ) = espectaculoService.getEspectuloFiltrado(campoDeBusqueda)
/*
    @PutMapping("/Espectaculo/editar/{id}")
    @Operation(summary = "Edita el espectaculo en el backend")
    fun update(@RequestBody espectaculo : EspectaculoDTO): Espectaculo {
        val instalacionId = instalacionService.getInstalacion(espectaculo.lugar)
        return espectaculoService.update(espectaculo.toEspectaculo(instalacionId))


    }

*/



}