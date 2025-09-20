package com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response;

public class Cuenta {
    
    private String idSucursalGestora;
    private String idProducto;
    private String idSubProducto;
    private String numeroTarjeta;
    private String origen;
    private String producto;
    private String tipo;
    
    public Cuenta() {}
    
    public String getIdSucursalGestora() {
        return idSucursalGestora;
    }
    
    public void setIdSucursalGestora(String idSucursalGestora) {
        this.idSucursalGestora = idSucursalGestora;
    }
    
    public String getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getIdSubProducto() {
        return idSubProducto;
    }
    
    public void setIdSubProducto(String idSubProducto) {
        this.idSubProducto = idSubProducto;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getOrigen() {
        return origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    public String getProducto() {
        return producto;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
