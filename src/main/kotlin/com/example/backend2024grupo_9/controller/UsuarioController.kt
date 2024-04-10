package com.example.backend2024grupo_9.controller

import com.example.backend2024grupo_9.DTO.UsuarioCreateDTO
import com.example.backend2024grupo_9.DTO.UsuarioLoginDTO
import com.example.backend2024grupo_9.DTO.toUsuario
import com.example.backend2024grupo_9.domain.Usuario
import com.example.backend2024grupo_9.servicios.UsuarioService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.http.MediaType;


@RestController
@CrossOrigin("http://localhost:5173")

class UsuarioController (@Autowired val userService : UsuarioService) {


    @GetMapping("/Usuario")
    fun getUsuario() = userService.getUser()

    @GetMapping("/Usuario/{id}")
    @Operation(summary = "Devuelve un usuario por id")
    fun getUsuario(@PathVariable id: Int) = userService.getUser(id)

    @PostMapping("/NuevoUsuario")
    @Operation(summary = "Crea un nuevo usuario")
    fun create(@RequestBody usuarioBody : UsuarioCreateDTO): Usuario {

        return userService.create(usuarioBody.toUsuario())
    }


    @PostMapping("/usuarioLogin")
    @Operation(summary = "Devuelve un usuario que coincida user y pass")
    fun postUsuarioLoggin(@RequestBody user: UsuarioLoginDTO) = userService.getUsuarioLogin(user)

    //@PostMapping("/usuarioLogin")
    //@Operation(summary = "Devuelve un usuario que coincida user y pass")
    //fun postUsuarioLoggin(@RequestBody user: Usuario) = userService.getUsuarioLogin(user)


    //esta la paso bianchi por error de tipo
    //@PostMapping("/usuarioLogin", consumes = [MediaType.APPLICATION_JSON_VALUE])
    //@Operation(summary = "Devuelve un usuario que coincida user y pass")
    //fun postUsuarioLoggin(@RequestBody user: Usuario) = userService.getUsuarioLogin(user)


}
