package com.divisas.crud_cuentas.controller;

import com.divisas.crud_cuentas.dto.CuentasRequest;
import com.divisas.crud_cuentas.dto.CuentasResponse;
import com.divisas.crud_cuentas.service.ICuentaService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class CrudController {

  private final ICuentaService cuentaService;

  public CrudController(ICuentaService cuentaService) {
    this.cuentaService = cuentaService;
  }

  @GetMapping("/getCuenta")
  public List<CuentasResponse> getCuenta() {
    return cuentaService.getCuentas();
  }

  @PostMapping("/insertCuenta")
  public CuentasResponse insertCuenta(@RequestBody CuentasRequest cuentasRequest) {

    return cuentaService.insertCuenta(cuentasRequest);
  }
}
