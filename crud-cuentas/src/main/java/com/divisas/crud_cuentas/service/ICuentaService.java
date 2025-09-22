package com.divisas.crud_cuentas.service;

import com.divisas.crud_cuentas.dto.CuentasRequest;
import com.divisas.crud_cuentas.dto.CuentasResponse;
import java.util.List;

public interface ICuentaService {
  List<CuentasResponse> getCuentas();

  CuentasResponse insertCuenta(CuentasRequest cuentasRequest);
}
