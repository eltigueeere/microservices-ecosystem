package com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response;

public class Ocupacion {
    
    private String idActividadEconomica;
    private String idGiro;
    private String actividadEconomica;
    private String giro;
    
    public Ocupacion() {}
    
    public String getIdActividadEconomica() {
        return idActividadEconomica;
    }
    
    public void setIdActividadEconomica(String idActividadEconomica) {
        this.idActividadEconomica = idActividadEconomica;
    }
    
    public String getIdGiro() {
        return idGiro;
    }
    
    public void setIdGiro(String idGiro) {
        this.idGiro = idGiro;
    }
    
    public String getActividadEconomica() {
        return actividadEconomica;
    }
    
    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }
    
    public String getGiro() {
        return giro;
    }
    
    public void setGiro(String giro) {
        this.giro = giro;
    }
}
