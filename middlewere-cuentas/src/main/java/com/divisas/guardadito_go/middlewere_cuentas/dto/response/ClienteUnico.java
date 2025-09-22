package com.divisas.guardadito_go.middlewere_cuentas.dto.response;

public class ClienteUnico {

  private String idPais;
  private String idCanal;
  private String idSucursal;
  private String folio;

  public String getIdPais() {
    return idPais;
  }

  public void setIdPais(String idPais) {
    this.idPais = idPais;
  }

  public String getIdCanal() {
    return idCanal;
  }

  public void setIdCanal(String idCanal) {
    this.idCanal = idCanal;
  }

  public String getIdSucursal() {
    return idSucursal;
  }

  public void setIdSucursal(String idSucursal) {
    this.idSucursal = idSucursal;
  }

  public String getFolio() {
    return folio;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }
}
