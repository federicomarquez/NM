package com.example.backend2024grupo_9.servicios

import com.example.backend2024grupo_9.DTO.EspectaculoDTO
import com.example.backend2024grupo_9.domain.Espectaculo
import com.example.backend2024grupo_9.repositorio.RepoEspectaculo
import com.example.backend2024grupo_9.repositorio.Repositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EspectaculoService {

    @Autowired
    lateinit var repoEspectaculo: RepoEspectaculo

    //lateinit var espectaculosYaFiltrados : List<Espectaculo>

    fun getEspectaculo() = repoEspectaculo.allInstances()

    fun getESpectulosActivos()  = repoEspectaculo.allInstancesActivos()

    fun getEspectaculo(id: Int) = repoEspectaculo.getById(id)

    fun create(nuevoEspectaculo : Espectaculo): Espectaculo {
        repoEspectaculo.create(nuevoEspectaculo)
        return nuevoEspectaculo
    }

    fun delete( id : Int){
        val espectaculo = repoEspectaculo.getById(id)
        repoEspectaculo.delete(espectaculo)
    }

    fun getEspectuloFiltrado(campoDeBusqueda: String?): List<Espectaculo> {
        if (campoDeBusqueda === null || campoDeBusqueda === ""){
        } else {
            val campoBusqueda = campoDeBusqueda.uppercase()
            return getEspectaculo().filter { it.banda.uppercase().contains(campoBusqueda) || it.lugar.nombre.uppercase().contains(campoBusqueda)}

        }
        return getEspectaculo()
    }
/*
    fun update (espectaculo : Espectaculo): Espectaculo {

        if(!repoEspectaculo.elementos.any{it.id == espectaculo.id}){
            repoEspectaculo.update(espectaculo)
        }

        return espectaculo
    }

*/
}