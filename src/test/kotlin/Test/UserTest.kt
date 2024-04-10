package Test

import com.example.backend2024grupo_9.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.uqbar.geodds.Point
import java.time.LocalDate



class Test : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    val usuarioMayorDeEdad = Usuario("UsuarioMayorDeEdad", LocalDate.now().minusYears(30),100,"mayor","sadas")
    val usuarioComentador = Usuario()
    val ubicacion = Ubicacion(Point(-34.66128, -58.36713))
    val teatroMalaAcustica = Teatro("Volterix", ubicacion,100000,false,100,500)
    val estadioCapacidad65 = Estadio("Velez",ubicacion,150000,20,15,30)
    val espectaculoRentMedia = Espectaculo( "Soda Estereo", teatroMalaAcustica, "No hay", 100000, RentabilidadPlena)
    val espectaculoRentBaja = Espectaculo("Aspera",estadioCapacidad65,"No hay",100000)
    val entrada2PlateaBaja  = Entrada(2, LocalDate.now(),espectaculoRentBaja,PlateaBaja)

    describe("casos de prueba para test ") {
        it("er") {
            usuarioMayorDeEdad.esValidoUser().shouldBe(true)
        }
        it("prueba triste") {
            usuarioMayorDeEdad.saldoEnPesos = 500
            usuarioMayorDeEdad.saldoEnPesos.shouldNotBe(400)
            usuarioMayorDeEdad.saldoEnPesos.shouldBe(500)

        }
    }

    describe("segundo caso") {
        it("Se compruba la edad del usuario ") {
            usuarioMayorDeEdad.edad().shouldBe(30)
        }
        it("asd") {
            usuarioMayorDeEdad.agregarAmigo(usuarioMayorDeEdad)
        }
    }

    it("se verifica funcionamiento de los comentarios") {
        usuarioComentador.agregarComentario(espectaculoRentMedia,"el show fue una mierda")
        usuarioComentador.agregarComentario(espectaculoRentBaja,"el show fue una mierda")

        usuarioComentador.comentarios.size.shouldBe(2)

    }
    it(" se verifica asistencia al show") {
        usuarioComentador.compras.add(entrada2PlateaBaja)
        usuarioComentador.validarAsistenciaAlShow(espectaculoRentBaja).shouldBe(true)

    }

})
