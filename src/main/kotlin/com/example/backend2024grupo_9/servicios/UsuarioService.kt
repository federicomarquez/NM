package com.example.backend2024grupo_9.servicios


import com.example.backend2024grupo_9.DTO.UsuarioLoginDTO
import com.example.backend2024grupo_9.domain.Usuario
import com.example.backend2024grupo_9.domain.genericException
import com.example.backend2024grupo_9.repositorio.RepoUser
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class UsuarioService {




    @Autowired
    lateinit var repoUsuario: RepoUser

    fun getUser() = repoUsuario.allInstances()
    fun getUser(id: Int) = repoUsuario.getById(id)

    fun deleteUser(id: Int) {
        repoUsuario.delete(repoUsuario.getById(id))
    }

    fun updateUser(usuario: Usuario) = repoUsuario.update(usuario)

    fun create(nuevoUsuario: Usuario): Usuario {
        repoUsuario.create(nuevoUsuario)
        return nuevoUsuario
    }
    fun getUsuarioLogin(user:UsuarioLoginDTO): Usuario {
        if(repoUsuario.getUserPass(user).isNotEmpty()) {
            return repoUsuario.getUserPass(user).first()
        } else {
            throw genericException("Los datos ingresados son incorrectos")
        }
    }
    //fun getUsuarioLogin(user:Usuario): Int {
    //    if(repoUsuario.getUserPass(user).isNotEmpty()) {
    //        return repoUsuario.getUserPass(user).first().id
    //    } else {
    //        throw genericException("Los datos ingresados son incorrectos")
    //    }
    //}
}