package com.divisas.crud_cuentas.dto;

import jakarta.validation.constraints.NotBlank;

public class CuentasRequest {

    Long idCuenta;
    @NotBlank(message = "Cuenta requerida")
    String cuenta;
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

}
