package com.divisas.guardadito_go.middlewere_cuentas.dto.response;

public class BusquedaCuentaResponse {
    
    private String mensaje;
    private String folio;
    private Resultado resultado;
    
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getFolio() {
        return folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    public Resultado getResultado() {
        return resultado;
    }
    
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
