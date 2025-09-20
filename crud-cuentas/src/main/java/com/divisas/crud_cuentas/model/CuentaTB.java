package com.divisas.crud_cuentas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentasTb")
public class CuentaTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuentas;

    private String cuenta;

    private String description;

    public CuentaTB() {
    }

    public CuentaTB(String cuenta, String description) {
        this.cuenta = cuenta;
        this.description = description;
    }

    public Long getIdCuentas() {
        return idCuentas;
    }

    public void setIdCuentas(Long idCuentas) {
        this.idCuentas = idCuentas;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
