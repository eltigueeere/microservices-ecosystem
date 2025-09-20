package com.divisas.crud_cuentas.service;

import java.util.List;

import com.divisas.crud_cuentas.dto.CuentasRequest;
import com.divisas.crud_cuentas.dto.CuentasResponse;

public interface ICuentaService {
    List<CuentasResponse> getCuentas();

    CuentasResponse insertCuenta(CuentasRequest cuentasRequest);
}