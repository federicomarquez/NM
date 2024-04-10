
import com.example.backend2024grupo_9.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.uqbar.geodds.Point
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month


class EspectaculoTest : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    val ubicacion = Ubicacion(Point(-34.66128, -58.36713))
    val estadioCapacidad65 = Estadio("Velez",ubicacion,150000,20,15,30)
    val espectaculo100DeRentabilidad= Espectaculo("Aspera",estadioCapacidad65,"No hay",100000,RentabilidadBaja,mutableListOf(), 500000.0, mutableListOf())
    val teatroBuenaAcustica = Teatro("Volterix", ubicacion,100000,true,50,50)
    val teatroMalaAcustica = Teatro("Volterix", ubicacion,100000,false,100,500)
    val teatroSoldOut = Teatro("Volterix", ubicacion,100000,false,2,2)
    val espectaculoRentBaja = Espectaculo("Aspera",estadioCapacidad65,"No hay",100000)
    val espectaculoRentMedia = Espectaculo( "Soda Estereo", teatroMalaAcustica, "No hay", 100000, RentabilidadPlena)
    val espectaculoRentMegaShow = Espectaculo( "Soda Estereo", teatroBuenaAcustica, "No hay", 100000, RentabilidadMegaShow)
    val espectaculoSoldOut = Espectaculo( "Soda Estereo", teatroSoldOut, "No hay", 100000, RentabilidadMegaShow)
    val espectaculoSoldOut2 = Espectaculo( "Soda Estereo", teatroSoldOut, "No hay", 100000, RentabilidadMegaShow)
    val entrada1pullman2 = Entrada(1, LocalDate.now(),espectaculoSoldOut2,Pullman)
    val entrada1pullman = Entrada(1, LocalDate.now(),espectaculoSoldOut,Pullman)
    val entrada2pullman = Entrada(2, LocalDate.now(),espectaculoSoldOut,Pullman)
    val entrada1PlateaBaja = Entrada(1, LocalDate.now(),espectaculoSoldOut,PlateaBaja)
    val entrada2PlateaBaja  = Entrada(2, LocalDate.now(),espectaculoSoldOut,PlateaBaja)
    val usuarioCompradorDeEntrada = Usuario(saldoEnPesos = 100000)
    val fecha1 = Funcion(LocalDateTime.of(1991, Month.SEPTEMBER, 25, 0, 0))

    describe("testeo de espectaculo en general" )
    {
3

        it("Se verifica que el costo de la rentabilidad es de 80% (BAJA)") {
            espectaculoRentBaja.rentabilidadActual().shouldBe(0.8)
        }
        it("Se verifica que el costo de la rentabilidad no sea de 100% (MEDIA)") {
            espectaculoRentBaja.rentabilidadActual().shouldNotBe(1.0)
        }
        it("Se verifica que el costo de la Instalación") {
            estadioCapacidad65.costo().shouldBe(150000)
        }
        it("Se verifica que el costo de la Instalación no sea el correcto") {
            estadioCapacidad65.costo().shouldNotBe(150001)
        }

        it("Se verifica que el costo de la Banda e Instalación") {
            espectaculoRentBaja.costoBandaEInstalacion().shouldBe(250000)
        }
        it("Se verifica que el costo de la Banda e Instalación no es el correcto") {
            espectaculoRentBaja.costoBandaEInstalacion().shouldNotBe(250001)
        }
        //Media
        it("Se verifica que el costo de la rentabilidad es de 100% (MEDIA)") {
            espectaculoRentMedia.rentabilidadActual().shouldBe(1.0)
        }
        it("Se verifica que el costo de la rentabilidad no sea diferente a 100% (BAJA)") {
            espectaculoRentMedia.rentabilidadActual().shouldNotBe(0.8)
        }
        it("Se verifica que el costo de la Banda e Instalación Media") {
            espectaculoRentMedia.costoBandaEInstalacion().shouldBe(200000)
        }
        //Mega Show
        it("Se verifica que el costo de la rentabilidad es de 130% (ALTA)") {
            espectaculoRentMegaShow.rentabilidadActual().shouldBe(1.3)
        }
        it("Se verifica que el costo de la rentabilidad no sea diferente a 100% (BAJA)") {
            espectaculoRentMegaShow.rentabilidadActual().shouldBe(0.8)
        }
        it("Se verifica que el costo de la Banda e Instalación Megashow") {
            espectaculoRentMegaShow.costoBandaEInstalacion().shouldBe(250000)
        }

        it ("se verifica el calculo de la rentabilidad del show con respecto a las ventas"){
            espectaculo100DeRentabilidad.rentabilidadDelShow().shouldBe(100)
        }

        it("se cambia la rentabilidad del show"){
            espectaculoRentBaja.estadoRentabilidad.shouldBe(RentabilidadBaja)
            espectaculoRentBaja.cambiarEstadoLaRentabilidad(RentabilidadPlena)
            espectaculoRentBaja.estadoRentabilidad.shouldBe(RentabilidadPlena)
        }

        it("se verifica que el show este completamente vendida"){
            teatroSoldOut.capacidadTotal().shouldBe(4)
            espectaculoSoldOut.agregrEntradaVendida(entrada1pullman)
            espectaculoSoldOut.agregrEntradaVendida(entrada2pullman)
            espectaculoSoldOut.soldOut().shouldBe(false)
            espectaculoSoldOut.agregrEntradaVendida(entrada1PlateaBaja)
            espectaculoSoldOut.agregrEntradaVendida(entrada2PlateaBaja)
            espectaculoSoldOut.soldOut().shouldBe(true)
        }
        it("se verifica recaudacion de ventas"){
            teatroSoldOut.capacidadTotal().shouldBe(4)
            entrada1pullman2.precioDeEntrada().shouldBe(78000)
            espectaculoSoldOut2.ventaDeEntrada(entrada1pullman2,usuarioCompradorDeEntrada,fecha1)
            espectaculoSoldOut2.recaudacion.shouldBe(78000)
            espectaculoSoldOut2.entradasDisponibles().shouldBe(3)

        }
        it ("costo de platea baja"){
            entrada1PlateaBaja.precioDeEntrada().shouldBe(84500)
        }
        it("no se puede vender entrada de show sold out") {
            espectaculoSoldOut.agregrEntradaVendida(entrada1pullman)
            espectaculoSoldOut.agregrEntradaVendida(entrada2pullman)
            espectaculoSoldOut.agregrEntradaVendida(entrada1PlateaBaja)
            espectaculoSoldOut.agregrEntradaVendida(entrada2PlateaBaja)
            espectaculoSoldOut.soldOut().shouldBe(true)
           // assertDoesNotThrow {espectaculoSoldOut.ventaDeEntrada(entrada1pullman,usuarioCompradorDeEntrada)}
        }

        }



})
