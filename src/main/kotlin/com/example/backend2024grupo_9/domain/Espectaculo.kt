package com.example.backend2024grupo_9.domain

import java.time.LocalDateTime


class Espectaculo(
  val banda: String = "",
  val lugar: Instalacion,
  val gira: String = "",
  val costoBanda: Int = 1,
  var estadoRentabilidad: Rentabilidad = RentabilidadBaja,
  var entradasVendidas: MutableList<Entrada> = mutableListOf(),
  var recaudacion :Double =0.0,
  var listaDeEspera :  MutableList<Usuario> = mutableListOf(),
  var fechas :  MutableList<Funcion> = mutableListOf(),
) : Entidad() {


  override fun toString(): String = this.banda
  fun agregarNuevaFuncion(fechaFuncion : LocalDateTime) = fechas.add(Funcion(fechaFuncion, this))
  fun quitarEntradaDisponibles(entrada: Entrada) = entradasVendidas.remove(entrada)
  fun agregrEntradaVendida(entrada: Entrada) = entradasVendidas.add(entrada)  // posiblemente esto puedda modificarse por una suma de la listas de entradas vendiadas de las funciones

  fun entradasDisponibles() = lugar.capacidadTotal() - cantidadDeEntradasVendidas()

  fun agregarUsuarioAEspera(usuario: Usuario) = listaDeEspera.add(usuario)

  fun hayEntradasVendidas() = cantidadDeEntradasVendidas() > 0

  fun validarBajaEspectaculo() {
      if (hayEntradasVendidas()) throw genericException(" No se puede dar de baja el espectaculo, HAY ENTRADAS VENDIDAS ")
  }

  fun cambiarEstadoLaRentabilidad(nuevoEstado: Rentabilidad) {
    estadoRentabilidad = nuevoEstado
  }

  // dashboard
  fun usuariosEnEspera() = listaDeEspera.count()
  fun soldOut() = cantidadDeEntradasVendidas() == lugar.capacidadTotal()

  fun cantidadDeEntradasVendidas() = entradasVendidas.count()

  // se hace una validacion
  // puede llegar a ser negativa (ROE)
  fun rentabilidadDelShow() = ((this.recaudacion - costoBandaEInstalacion()) / costoBandaEInstalacion()) * 100


  // TESTEAR CAUDACION
  fun recaudacionDeVentas(usuario: Usuario, entrada: Entrada) {
    usuario.abonarEntrada(entrada) // falta this para especificar que sea de ese show?
    this.recaudacion += entrada.precioDeEntrada()
  }

  fun costoBandaEInstalacion() = costoBanda + lugar.costo()

  fun costoAdicionalPorCapacidad() = costoBandaEInstalacion() / lugar.capacidadTotal()

  fun rentabilidadActual() = estadoRentabilidad.porcentaje()


  fun ventaDeEntrada(entrada: Entrada, usuario: Usuario,funcion: Funcion) {
    validarEntradasDisponibles()
    validarSaldoDeUsuario(usuario, entrada)
    recaudacionDeVentas(usuario, entrada)
    agregrEntradaVendida(entrada)
    funcion.añadirEntradaVendida(entrada)

    usuario.agregarCompra(entrada)
  }


  fun hayDineroSuficiente(usuario: Usuario, entrada: Entrada) = usuario.saldoEnPesos >= entrada.precioDeEntrada()
  fun validarSaldoDeUsuario(usuario: Usuario, entrada: Entrada) {
    if (!hayDineroSuficiente(usuario, entrada)) throw genericException(" No hay suficiente dinero ")
  }

fun validarEntradasDisponibles(){ if(soldOut()) throw genericException(" No hay entradas disponibles para este show ") }


  // validaciones
  fun esValidoBanda() :Boolean = banda.isNotEmpty()
  fun esValidoGira() :Boolean = gira.isNotEmpty()
  fun esSaldoCostoBanda() : Boolean = costoBanda >=0
  fun validarSaldo(){ if(!esSaldoCostoBanda()) throw genericException(" El saldo no puede ser negativo") }


  override fun validar() {
    esValidoBanda()
    validarSaldo()
    esValidoGira ()
  }



}



