
import com.example.backend2024grupo_9.domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.uqbar.geodds.Point
import java.time.LocalDate



class EntradaTest : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    val ubicacion = Ubicacion(Point(-34.66128, -58.36713))
    val estadioCapacidad65 = Estadio("Velez",ubicacion,150000,20,15,30)
    val teatroBuenaAcustica = Teatro("Volterix", ubicacion,100000,true,50,50)
    val teatroMalaAcustica = Teatro("Volterix", ubicacion,100000,false,100,500)
    val ubicacionEstadioMonumental = Ubicacion(
        org.uqbar.geodds.Point(-34.57934, -58.43248)
    )
    val instalacionEstadioMonumental = Estadio(
        nombre = "Estadio Monumental, River Plate",
        ubicacion = ubicacionEstadioMonumental,
        costo = 10000
    )
    val espectaculoACDC = Espectaculo(
        banda = "AC/DC",
        lugar = instalacionEstadioMonumental,
        gira = "Power up tour"
    )
    val entradita = Entrada(espectaculo = espectaculoACDC)


    describe("o") {


    }


    describe("testeo de la instalacion teatros" )
    {
        it("Costo de teatro con buena acustica ") {
            entradita.precioDeEntrada().shouldBe(8266.4)
        }

    }




})
