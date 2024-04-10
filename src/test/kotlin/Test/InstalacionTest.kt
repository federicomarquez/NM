
import com.example.backend2024grupo_9.domain.Estadio
import com.example.backend2024grupo_9.domain.Teatro
import com.example.backend2024grupo_9.domain.Ubicacion
import com.example.backend2024grupo_9.domain.Usuario
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.uqbar.geodds.Point
import java.time.LocalDate



class InstalacionTest : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    val ubicacion = Ubicacion(Point(-34.66128, -58.36713))
    val estadioCapacidad65 = Estadio("Velez",ubicacion,150000,20,15,30)
    describe("casos de prueba para test para el estadio") {

        it("Costo del estadio ") {
            estadioCapacidad65.costo().shouldBe(150000)
        }
        it("Calculo de la capacidad del estacio") {
            estadioCapacidad65.capacidadTotal().shouldBe(65)

        }
    }
    val teatroBuenaAcustica = Teatro("Volterix", ubicacion,100000,true,50,50)
    val teatroMalaAcustica = Teatro("Volterix", ubicacion,100000,false,100,500)

    describe("testeo de la instalacion teatros" )
    {
        it("Costo de teatro con buena acustica ") {
            teatroBuenaAcustica.costo().shouldBe(150000)
        }
        it("Costo de teatro con mala acustica ") {
            teatroMalaAcustica.costo().shouldBe(100000)
        }
        it("Capacidad teatro con buena acustica ") {
            teatroBuenaAcustica.capacidadTotal().shouldBe(100)
        }
        it("Capacidad teatro con Mala acustica ") {
            teatroMalaAcustica.capacidadTotal().shouldBe(600)
        }
    }



})
