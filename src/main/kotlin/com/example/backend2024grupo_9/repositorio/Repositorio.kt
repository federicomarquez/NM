package com.example.backend2024grupo_9.repositorio

import com.example.backend2024grupo_9.DTO.UsuarioLoginDTO
import com.example.backend2024grupo_9.domain.*
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
open class Repositorio<T : Entidad>() {
    val elementos: MutableList<T> = mutableListOf()
    var siguienteID: Int = 1

    fun incrementadorAsignador(elemento: T) {
        elemento.id = siguienteID++
    }

    fun allInstancesActivos() = elementos.filter{ it.activo }
    fun allInstances() = elementos

    fun existeElId(id: Int): Boolean = elementos.any { it.id == id }


    fun create(elemento: T) {
        //elemento.validar()
        validarInExistencia(elemento)
        this.incrementadorAsignador(elemento)
        elementos.add(elemento)
    }

    fun delete(elemento: T) {
       // elementos.remove(getById(elemento.id))
        val elementoDesac = this.getById(elemento.id)
        return elementoDesac.desactivar()
    }

    fun update(elemento: T) {
        elemento.validar()
        val elementoViejo = getById(elemento.id)
        val index = elementos.indexOf(elementoViejo)
        elementos[index] = elemento
    }

    fun getById(id: Int): T {
        validarId(id)
        return elementos.first { it.id == id }
    }


    fun validarInExistencia(elemento: T) {
        if (existeElId(elemento.id)) throw genericException("No se pudo crear, ID ya se encuentra utilizado")
    }

    fun validarId(id: Int) {
        //    if (!existeElId(id)) throw ("El ID $id no es valido")
    }

    fun clear() {
        elementos.clear()
    }
}
@Repository
    open class RepoUser : Repositorio<Usuario>() {

        //fun getUserPass(usuario: UsuarioService) =
        //        allInstances().filter { it.usuario == user.usuario && it.pwd == user.pwd }

        fun search(nombreABuscar: String) = allInstances().filter { it.nombreYApellido.contains(nombreABuscar) }

        fun searchByRol(rol: UsuarioRole) = allInstances().filter { it.rol == rol }


        fun getUserPass(userIdentificador: UsuarioLoginDTO) = elementos.filter { user -> user.accesoUsuario(userIdentificador) }


        //fun getUserPass(userIdentificador: Usuario) = elementos.filter { user -> user.accesoUsuario(userIdentificador) }



    }
@Repository
    open class RepoEspectaculo : Repositorio<Espectaculo>() {
        fun search(nombreABuscar: String) = allInstances().filter { it.banda.contains(nombreABuscar) }

    }

@Repository
    open class RepoEntrada : Repositorio<Entrada>() {
        fun search(numeroABuscar: Int) = allInstances().filter { it.numero.equals(numeroABuscar) }

         fun idEspectaculo(id: Int): List<Entrada> = allInstances().filter { it.espectaculo.id == id }

    }


@Repository
    open class RepoInstalacion : Repositorio<Instalacion>() {
        fun search(nombreABuscar: String) = allInstances().filter { it.nombre.contains(nombreABuscar) }

}

@Repository
    open class RepoFuncion : Repositorio<Funcion>(){

        fun getByIds(ids: List<Int>): List<Funcion> {
        val elementosEncontrados = mutableListOf<Funcion>()
        ids.forEach { id -> elementosEncontrados.addAll(elementos.filter { it.id == id }) }
        return elementosEncontrados
    }

    }