package com.example.backend2024grupo_9.domain

import com.example.backend2024grupo_9.DTO.UsuarioLoginDTO
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Usuario(
    val nombreYApellido :String ="HOLA COMOESTAS",
    val fechaDeNacimiento : LocalDate = LocalDate.now(),
    var saldoEnPesos: Int = 10000000,
    val usuario :String ="",
    val pwd :String ="",
    var amigos : MutableList<Usuario> =  mutableListOf(),
    val rol : UsuarioRole = UsuarioRole.COMPRADOR,
    var compras :  MutableList<Entrada> =  mutableListOf(),
    var aguardandoNuevoEspectaculo : MutableList<Espectaculo> =  mutableListOf(),
    var comentarios: MutableMap <Espectaculo, String> = mutableMapOf()
) : Entidad()
    {


    fun edad() = ChronoUnit.YEARS.between(fechaDeNacimiento, LocalDate.now())

    fun quitarAmigo(unAmigo : Usuario) = amigos.remove(unAmigo)
    fun agregarAmigo(nuevoAmigo : Usuario) = amigos.add(nuevoAmigo)

    fun agregarCompra(entrada: Entrada) = compras.add(entrada)
    fun validarAsistenciaAlShow(espectaculo: Espectaculo): Boolean {
            return compras.find { it.espectaculo == espectaculo }?.let { true } ?: false
        }
    fun agregarComentario(espectaculo: Espectaculo, comentario: String) {
        validarAsistenciaAlShow(espectaculo)
        this.comentarios[espectaculo] = comentario
    }

    fun agregarEsperaNuevoEspectaculo(espectaculo: Espectaculo) = aguardandoNuevoEspectaculo.add(espectaculo)
    fun quitarEsperaNuevoEspectaculo(espectaculo: Espectaculo) = aguardandoNuevoEspectaculo.remove(espectaculo)
    fun abonarEntrada(entrada: Entrada) = saldoEnPesos - entrada.precioDeEntrada()

    fun esperoEvento(espectaculo: Espectaculo) = espectaculo.agregarUsuarioAEspera(this)

    // validaciones
   // faltan excepciones
    fun esValidoNombre() :Boolean = nombreYApellido.isNotEmpty()
    fun validarNombre(){ if(!esValidoNombre()) throw genericException(" No es valido el nombre vacio") }

    fun esValidoUser() :Boolean = usuario.isNotEmpty()
    fun validarUser(){ if(!esValidoUser()) throw genericException(" No es valido un usuario vacio") }
    fun esSaldoValido() : Boolean = saldoEnPesos >=0
    fun validarSaldo(){ if(!esSaldoValido()) throw genericException(" El saldo no puede ser negativo") }
    fun esValidaFechaNacimiento(): Boolean = fechaDeNacimiento.isBefore(LocalDate.now())
    //fun validarFecha(){ if(!esValidaFechaNacimiento()) throw genericException(" La fecha no puede ser mayor al dia actual") }

    override fun validar() {
        validarNombre()
        validarUser()
        validarSaldo()
        //validarFecha()
    }



        fun accesoUsuario(user: UsuarioLoginDTO): Boolean {
            return user.user == usuario && user.pass == pwd
        }

        //fun accesoUsuario(user: Usuario): Boolean {
        //    return user.usuario == usuario && user.pwd == pwd
        //}



}