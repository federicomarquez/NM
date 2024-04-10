package com.example.backend2024grupo_9.servicios

import com.example.backend2024grupo_9.repositorio.RepoInstalacion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class InstalacionService {

    @Autowired
    lateinit var repoInstalacion: RepoInstalacion

    fun getInstalacion() = repoInstalacion.allInstances()

    fun getInstalacion(id: Int) = repoInstalacion.getById(id)



}