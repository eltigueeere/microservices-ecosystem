package com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response;

public class Direccion {

  private String idEstado;
  private String idMunicipio;
  private String estado;
  private String municipio;
  private String colonia;
  private String calle;
  private String numeroExterior;
  private String numeroInterior;
  private String codigoPostal;

  public Direccion() {}

  public String getIdEstado() {
    return idEstado;
  }

  public void setIdEstado(String idEstado) {
    this.idEstado = idEstado;
  }

  public String getIdMunicipio() {
    return idMunicipio;
  }

  public void setIdMunicipio(String idMunicipio) {
    this.idMunicipio = idMunicipio;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getMunicipio() {
    return municipio;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public String getNumeroExterior() {
    return numeroExterior;
  }

  public void setNumeroExterior(String numeroExterior) {
    this.numeroExterior = numeroExterior;
  }

  public String getNumeroInterior() {
    return numeroInterior;
  }

  public void setNumeroInterior(String numeroInterior) {
    this.numeroInterior = numeroInterior;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }
}
