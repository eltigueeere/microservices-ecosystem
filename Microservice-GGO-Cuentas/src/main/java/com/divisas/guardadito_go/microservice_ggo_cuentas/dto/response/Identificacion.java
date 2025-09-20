package com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response;

public class Identificacion {
    
    private String idTipo;
    private String tipo;
    private String numero;
    
    public Identificacion() {}
    
    public String getIdTipo() {
        return idTipo;
    }
    
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
