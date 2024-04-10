package com.example.backend2024grupo_9.bootstrap

import com.example.backend2024grupo_9.DTO.UsuarioLoginDTO
import com.example.backend2024grupo_9.domain.*
import com.example.backend2024grupo_9.repositorio.*
import org.springframework.beans.factory.InitializingBean


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.Month

@Service
class NochesMagicasBootstrap : InitializingBean {


    @Autowired(required = true)
    lateinit var repoUser: RepoUser

    @Autowired(required = true)
    lateinit var repoInstalacion: RepoInstalacion

    @Autowired(required = true)
    lateinit var repofuncion : RepoFuncion

    @Autowired(required = true)
    lateinit var repoEspectaculo: RepoEspectaculo

    @Autowired(required = true)
    lateinit var repoEntrada : RepoEntrada

    fun crearUser(){
        repoUser.create(usuarioPrueba)
        repoUser.create(usuarioPrueba1)
        repoUser.create(usuarioPrueba2)
    }

    fun crearInstalacion(){
        repoInstalacion.create(instalacionPrueba)
        repoInstalacion.create(instalacionEstadioKempes)
        repoInstalacion.create(instalacionTeatroColon)
        repoInstalacion.create(instalacionEstadioMonumental)
        repoInstalacion.create(instalacionTeatroArgentinoLaPlata)
    }

    fun crearEspectaculo(){
        repoEspectaculo.create(espectaculoPrueba)
        repoEspectaculo.create(espectaculoACDC)
        repoEspectaculo.create(espectaculoDuaLipa)
        repoEspectaculo.create(espectaculoMetallica)
        repoEspectaculo.create(espectaculoColdPlay)

    }
    fun crearFuncion(){
        repofuncion.create(funcion1)
    }
    fun creacEntrada() {
        repoEntrada.create(entradita)
        repoEntrada.create(entradita2)
        repoEntrada.create(entradita3)
        repoEntrada.create(entradita4)
        repoEntrada.create(entradita5)
        repoEntrada.create(entradita6)
        repoEntrada.create(entradita7)
        repoEntrada.create(entradita8)
        repoEntrada.create(entradita9)
        repoEntrada.create(entradita10)
        repoEntrada.create(entradita11)
        repoEntrada.create(entradita12)
    }
    
    override fun afterPropertiesSet() {
        crearInstalacion()
        crearUser()
        crearEspectaculo()
        creacEntrada()
        crearFuncion()
        espectaculoColdPlay.agregarNuevaFuncion(LocalDateTime.of(2024,12,20,20,0))

    }






    val fecha1 = LocalDateTime.of(1991, Month.SEPTEMBER, 25, 0, 0)
    val fecha2 = LocalDateTime.of(2024, Month.JANUARY, 15, 0, 0)
    val fecha3 = LocalDateTime.of(2000, Month.JULY, 10, 0, 0)
    val fecha4 = LocalDateTime.of(2010, Month.MARCH, 20, 0, 0)
    val fecha5 = LocalDateTime.of(2015, Month.DECEMBER, 5, 0, 0)
    val fecha6 = LocalDateTime.of(2018, Month.AUGUST, 28, 0, 0)
    val fecha7 = LocalDateTime.of(2022, Month.MAY, 17, 0, 0)
    val fecha8 = LocalDateTime.of(2023, Month.OCTOBER, 22, 0, 0)
    val fecha9 = LocalDateTime.of(2025, Month.JUNE, 8, 0, 0)
    val fecha10 = LocalDateTime.of(2030, Month.FEBRUARY, 14, 0, 0)
    val fecha11 = LocalDateTime.of(2040, Month.NOVEMBER, 3, 0, 0)
    val fecha12 = LocalDateTime.of(2050, Month.APRIL, 1, 0, 0)

    val direccionBelgrano = Ubicacion(
        org.uqbar.geodds.Point(-32.66128, -55.36713)
    )

    val ubicacionEstadioMonumental = Ubicacion(
        org.uqbar.geodds.Point(-34.57934, -58.43248)
    )

    val ubicacionTeatroColon = Ubicacion(
        org.uqbar.geodds.Point(-34.60314, -58.37723)
    )

    val ubicacionEstadioKempes = Ubicacion(
        org.uqbar.geodds.Point(-31.42056, -64.17944)
    )

    val ubicacionTeatroArgentinoLaPlata = Ubicacion(
        org.uqbar.geodds.Point(-34.92069, -57.94944)
    )




    val instalacionPrueba = Teatro(
        nombre = "Teatro Juanito",
        ubicacion = direccionBelgrano
    )

    val instalacionEstadioMonumental = Estadio(
        nombre = "Estadio Monumental, River Plate",
        ubicacion = ubicacionEstadioMonumental,
        costo = 10000
    )
    val instalacionEstadioKempes = Estadio(
        nombre = "Estadio Kempes",
        ubicacion = ubicacionEstadioKempes,
        costo = 5000
    )

    val instalacionTeatroColon = Teatro(
        nombre = "Teatro Colon",
        ubicacion = ubicacionTeatroColon
    )

    val instalacionTeatroArgentinoLaPlata = Teatro(
        nombre = "Teatrao Argentino de La Plata",
        ubicacion = ubicacionTeatroArgentinoLaPlata
    )
    

    val espectaculoPrueba = Espectaculo(
        banda = "Los Redondos",
        lugar = instalacionPrueba,
        gira = "Gira 2024"

    )

    val espectaculoACDC = Espectaculo(
        banda = "AC/DC",
        lugar = instalacionEstadioMonumental,
        gira = "Power up tour",
        //fechas = mutableListOf(funcion1)

    )

    val espectaculoDuaLipa = Espectaculo(
        banda = "Dua Lipa",
        lugar = instalacionTeatroColon,
        gira = "Future Nostalgia",
        //fechas = mutableListOf(funcion1)
    )

    val espectaculoMetallica = Espectaculo(
        banda = "Metallica",
        lugar = instalacionEstadioKempes,
        gira = "worldwired tour 2017",
        //fechas = mutableListOf(funcion1)

    )

    val espectaculoColdPlay = Espectaculo(
        banda = "Coldplay",
        lugar = instalacionTeatroArgentinoLaPlata,
        gira = "music of the spheres",
        //fechas = mutableListOf(funcion1)
    )


    val funcion1 = Funcion(
        fecha = LocalDateTime.of(1991, Month.SEPTEMBER, 25, 0, 0),
        espectaculoACDC
    )




    val entradita = Entrada(espectaculo = espectaculoACDC, sector = PlateaAlta)
    val entradita2 = Entrada(espectaculo = espectaculoACDC, sector = Palco)
    val entradita3 = Entrada(espectaculo = espectaculoACDC, sector = Campo)

    val entradita4 = Entrada(espectaculo = espectaculoPrueba, sector = PlateaBaja)
    val entradita5 = Entrada(espectaculo = espectaculoPrueba, sector = Pullman)

    val entradita6 = Entrada(espectaculo = espectaculoDuaLipa, sector = PlateaBaja)
    val entradita7 = Entrada(espectaculo = espectaculoDuaLipa, sector = Pullman)

    val entradita8 = Entrada(espectaculo = espectaculoMetallica, sector = PlateaAlta)
    val entradita9 = Entrada(espectaculo = espectaculoMetallica, sector = Palco)
    val entradita10 = Entrada(espectaculo = espectaculoMetallica, sector = Campo)

    val entradita11 = Entrada(espectaculo = espectaculoColdPlay, sector = PlateaBaja)
    val entradita12 = Entrada(espectaculo = espectaculoColdPlay, sector = Pullman)






    val usuarioPrueba = Usuario(
        usuario = "juanperez1",
        pwd = "1234",
        rol = UsuarioRole.ADMINISTRADOR,
        comentarios = mutableMapOf(espectaculoPrueba to "excelente show", espectaculoACDC to "una experiencia unica")

    )
    val usuarioPrueba1 = Usuario(
        nombreYApellido = "Verito 666",
        usuario = "veritorezando",
        pwd = "diosito123",
        compras= mutableListOf(entradita),
        comentarios = mutableMapOf(espectaculoPrueba to "excelente show", espectaculoACDC to "una experiencia unica"),
        amigos = mutableListOf (usuarioPrueba)

    )
    val usuarioPrueba2 = Usuario(
        usuario = "Paraguas",
        pwd = "raton123",
        comentarios = mutableMapOf(espectaculoPrueba to "excelente show", espectaculoACDC to "una experiencia unica"),
        amigos = mutableListOf (usuarioPrueba,usuarioPrueba1)
    )

    val userPrueba = UsuarioLoginDTO (
        user = "juanperez",
        pass = "1234",
    )


}
