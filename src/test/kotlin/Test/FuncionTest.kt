package Test

import com.example.backend2024grupo_9.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.uqbar.geodds.Point
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

class FuncionTest : DescribeSpec( {
    isolationMode = IsolationMode.InstancePerTest

    val usuarioMayorDeEdad = Usuario("UsuarioMayorDeEdad", LocalDate.now().minusYears(30),1000000000,"mayor","sadas")
    val ubicacion = Ubicacion(Point(-34.66128, -58.36713))
    val teatroMalaAcustica = Teatro("Volterix", ubicacion,100000,false,100,500)
    val teatroPocoEspacio = Teatro("chiquitons", ubicacion,100000,false,1,1)
    val espectaculoRentMedia = Espectaculo( "Soda Estereo", teatroMalaAcustica, "No hay", 100000, RentabilidadPlena)
    val entrada2PlateaBaja1 = Entrada(2, LocalDate.now(),espectaculoRentMedia, PlateaBaja)
    val entrada2PlateaBaja2  = Entrada(3, LocalDate.now(),espectaculoRentMedia, PlateaBaja)
    val entrada2PlateaBaja3  = Entrada(4, LocalDate.now(),espectaculoRentMedia, PlateaBaja)
    val fecha1 = Funcion(LocalDateTime.of(1991, Month.SEPTEMBER, 25, 0, 0))



    describe("testeo de la compra "){
        espectaculoRentMedia.agregarNuevaFuncion(fecha1)
        it("se verifica la compra de una entrada"){

            usuarioMayorDeEdad.agregarCompra(entrada2PlateaBaja1)
            usuarioMayorDeEdad.compras.size.shouldBe(1)
        }
        it("se verifica el añadir entrada"){
            fecha1.añadirEntradaVendida(entrada2PlateaBaja1)
            fecha1.entradasVendidas.size.shouldBe(1)
        }
    }


    describe("testeo de las funciones "){
        espectaculoRentMedia.agregarNuevaFuncion(fecha1)
        it("se verifica funcion entradasVendidasPorSectorConteo()"){

            usuarioMayorDeEdad.agregarCompra(entrada2PlateaBaja1)
            usuarioMayorDeEdad.agregarCompra(entrada2PlateaBaja2)
            usuarioMayorDeEdad.agregarCompra(entrada2PlateaBaja3)

            //println(fecha1.entradasVendidasPorSectorConteo().values)
            //fecha1.entradasVendidasPorSectorConteo().values.shouldBe(3)
        }

    }
})