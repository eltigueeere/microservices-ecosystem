package com.divisas.guardadito_go.microservice_ggo_cuentas.controller;

import com.divisas.guardadito_go.microservice_ggo_cuentas.dto.request.BusquedaCuentaRequest;
import com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response.BusquedaCuentaResponse;
import com.divisas.guardadito_go.microservice_ggo_cuentas.service.ExternalMicroserviceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

  @Autowired private ExternalMicroserviceService externalMicroserviceService;

  @PostMapping("/busquedas")
  public ResponseEntity<BusquedaCuentaResponse> buscarCuentas(
      @RequestHeader("x-id-acceso") @NotBlank(message = "x-id-acceso es requerido")
          String xIdAcceso,
      @RequestHeader("x-aplicacion-origen") @NotBlank(message = "x-aplicacion-origen es requerido")
          String xAplicacionOrigen,
      @Valid @RequestBody BusquedaCuentaRequest request) {

    BusquedaCuentaResponse response =
        externalMicroserviceService.procesarBusquedaCuenta(request, xIdAcceso);

    return ResponseEntity.ok(response);
  }
}
