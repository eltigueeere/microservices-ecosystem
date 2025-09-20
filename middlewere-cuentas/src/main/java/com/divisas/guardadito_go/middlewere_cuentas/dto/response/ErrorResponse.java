package com.divisas.guardadito_go.middlewere_cuentas.dto.response;

import java.util.List;

public class ErrorResponse {
    
    private String codigo;
    private String mensaje;
    private String folio;
    private String info;
    private List<String> detalles;
    
    public ErrorResponse() {}
    
    public ErrorResponse(String codigo, String mensaje, String folio, String info, List<String> detalles) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.folio = folio;
        this.info = info;
        this.detalles = detalles;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
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
    
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public List<String> getDetalles() {
        return detalles;
    }
    
    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }
}
