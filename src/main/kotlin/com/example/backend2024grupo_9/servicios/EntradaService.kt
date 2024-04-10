package com.example.backend2024grupo_9.servicios

import com.example.backend2024grupo_9.repositorio.RepoEntrada
import com.example.backend2024grupo_9.repositorio.RepoEspectaculo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EntradaService {

    @Autowired
    lateinit var repoEntrada: RepoEntrada

    fun getEntrada() = repoEntrada.allInstances()

    fun getEntrada(id: Int) = repoEntrada.getById(id)
    fun getEspectaculo(id: Int) = repoEntrada.idEspectaculo(id)



}