package com.divisas.guardadito_go.middlewere_cuentas.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class BusquedaCuentaRequest {
    
    @NotNull(message = "idBusqueda es requerido")
    private Integer idBusqueda;
    
    @NotBlank(message = "datoBusqueda es requerido")
    private String datoBusqueda;
    
    public BusquedaCuentaRequest() {}
    
    public BusquedaCuentaRequest(Integer idBusqueda, String datoBusqueda) {
        this.idBusqueda = idBusqueda;
        this.datoBusqueda = datoBusqueda;
    }
    
    public Integer getIdBusqueda() {
        return idBusqueda;
    }
    
    public void setIdBusqueda(Integer idBusqueda) {
        this.idBusqueda = idBusqueda;
    }
    
    public String getDatoBusqueda() {
        return datoBusqueda;
    }
    
    public void setDatoBusqueda(String datoBusqueda) {
        this.datoBusqueda = datoBusqueda;
    }
}
