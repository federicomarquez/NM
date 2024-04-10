package com.example.backend2024grupo_9.DTO
import java.time.LocalDate



import com.example.backend2024grupo_9.domain.Usuario

data class UsuarioLoginDTO(val user: String, val pass: String)

fun Usuario.toDTO() = UsuarioLoginDTO(user = usuario, pass = pwd)

data class UsuarioCreateDTO(val nombreYApellido: String, val fechaDeNacimiento: LocalDate, val usuario: String, val pwd: String)
fun UsuarioCreateDTO.toUsuario() = Usuario(nombreYApellido = nombreYApellido, fechaDeNacimiento = fechaDeNacimiento, usuario =  usuario, pwd =  pwd)


