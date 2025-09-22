package com.divisas.guardadito_go.middlewere_cuentas.controller;

import com.divisas.guardadito_go.middlewere_cuentas.dto.request.BusquedaCuentaRequest;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.BusquedaCuentaResponse;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.Cliente;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.ClienteUnico;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.Cuenta;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.Direccion;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.Identificacion;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.Ocupacion;
import com.divisas.guardadito_go.middlewere_cuentas.dto.response.Resultado;
import jakarta.validation.Valid;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/middleware")
public class MiddlewareController {

  static final Logger logger = LoggerFactory.getLogger(MiddlewareController.class);

  @PostMapping("/test")
  public BusquedaCuentaResponse testMiddleware(
      @Valid @RequestBody BusquedaCuentaRequest busquedaCuentaRequest) {
    logger.info("Ejemolo middleware");
    BusquedaCuentaResponse busquedaCuentaResponse = new BusquedaCuentaResponse();

    busquedaCuentaResponse.setFolio("1039484743838943");
    busquedaCuentaResponse.setMensaje("Todo ok");

    Resultado resultado = new Resultado();
    resultado.setClienteRegistrado(true);

    Cliente cliente = new Cliente();
    cliente.setIdPaisNacimiento("484");
    cliente.setIdNacionalidad("484");
    cliente.setNombre("Juan");
    cliente.setApellidoPaterno("Pérez");
    cliente.setApellidoMaterno("García");
    cliente.setPaisNacimiento("México");
    cliente.setNacionalidad("Mexicana");
    cliente.setTipoGenero("M");
    cliente.setGenero("Masculino");
    cliente.setFechaNacimiento("1990-05-15");

    Direccion direccion = new Direccion();
    direccion.setIdEstado("09");
    direccion.setIdMunicipio("015");
    direccion.setEstado("Ciudad de México");
    direccion.setMunicipio("Benito Juárez");
    direccion.setColonia("Del Valle");
    direccion.setCalle("Av. Insurgentes Sur");
    direccion.setNumeroExterior("1234");
    direccion.setNumeroInterior("5A");
    direccion.setCodigoPostal("03100");
    cliente.setDireccion(direccion);

    Ocupacion ocupacion = new Ocupacion();
    ocupacion.setIdActividadEconomica("6201");
    ocupacion.setIdGiro("01");
    ocupacion.setActividadEconomica("Desarrollo de sistemas informáticos");
    ocupacion.setGiro("Tecnología");
    cliente.setOcupacion(ocupacion);

    Identificacion identificacion = new Identificacion();
    identificacion.setIdTipo("01");
    identificacion.setTipo("INE");
    identificacion.setNumero("PEGJ900515HDFRRN01");
    cliente.setIdentificacion(identificacion);

    ClienteUnico clienteUnico = new ClienteUnico();
    clienteUnico.setIdPais("484");
    clienteUnico.setIdCanal("01");
    clienteUnico.setIdSucursal("001");
    clienteUnico.setFolio("CU123456789");
    cliente.setClienteUnico(clienteUnico);

    Cuenta cuenta1 = new Cuenta();
    cuenta1.setIdSucursalGestora("001");
    cuenta1.setIdProducto("01");
    cuenta1.setIdSubProducto("001");
    cuenta1.setNumeroTarjeta("4152313412341234");
    cuenta1.setOrigen("Digital");
    cuenta1.setProducto("Cuenta de Ahorro");
    cuenta1.setTipo("Ahorro");

    Cuenta cuenta2 = new Cuenta();
    cuenta2.setIdSucursalGestora("001");
    cuenta2.setIdProducto("02");
    cuenta2.setIdSubProducto("002");
    cuenta2.setNumeroTarjeta("5412345678901234");
    cuenta2.setOrigen("Sucursal");
    cuenta2.setProducto("Tarjeta de Crédito");
    cuenta2.setTipo("Crédito");

    cliente.setCuentas(Arrays.asList(cuenta1, cuenta2));

    resultado.setCliente(cliente);
    busquedaCuentaResponse.setResultado(resultado);

    return busquedaCuentaResponse;
  }
}
