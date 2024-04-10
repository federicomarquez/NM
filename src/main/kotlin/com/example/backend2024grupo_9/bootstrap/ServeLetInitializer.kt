package com.example.backend2024grupo_9.bootstrap

import com.example.backend2024grupo_9.Backend2024Grupo9Application
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServeLetInitializer : SpringBootServletInitializer(){

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Backend2024Grupo9Application::class.java)
    }
}