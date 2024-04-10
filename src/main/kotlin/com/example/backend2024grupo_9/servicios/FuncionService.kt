package com.example.backend2024grupo_9.servicios

import com.example.backend2024grupo_9.repositorio.RepoFuncion
import com.example.backend2024grupo_9.repositorio.RepoInstalacion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuncionService {

    @Autowired
    lateinit var repoFuncion : RepoFuncion

    fun getFunciones() = repoFuncion.allInstances()

    fun getByIdFuncion(id: List<Int>) = repoFuncion.getByIds(id)

}