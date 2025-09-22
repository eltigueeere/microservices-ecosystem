package com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response;

import java.util.List;

public class Cliente {

  private String idPaisNacimiento;
  private String idNacionalidad;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String paisNacimiento;
  private String nacionalidad;
  private String tipoGenero;
  private String genero;
  private String fechaNacimiento;
  private Direccion direccion;
  private Ocupacion ocupacion;
  private Identificacion identificacion;
  private ClienteUnico clienteUnico;
  private List<Cuenta> cuentas;

  public Cliente() {}

  public String getIdPaisNacimiento() {
    return idPaisNacimiento;
  }

  public void setIdPaisNacimiento(String idPaisNacimiento) {
    this.idPaisNacimiento = idPaisNacimiento;
  }

  public String getIdNacionalidad() {
    return idNacionalidad;
  }

  public void setIdNacionalidad(String idNacionalidad) {
    this.idNacionalidad = idNacionalidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public String getPaisNacimiento() {
    return paisNacimiento;
  }

  public void setPaisNacimiento(String paisNacimiento) {
    this.paisNacimiento = paisNacimiento;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getTipoGenero() {
    return tipoGenero;
  }

  public void setTipoGenero(String tipoGenero) {
    this.tipoGenero = tipoGenero;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public Ocupacion getOcupacion() {
    return ocupacion;
  }

  public void setOcupacion(Ocupacion ocupacion) {
    this.ocupacion = ocupacion;
  }

  public Identificacion getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(Identificacion identificacion) {
    this.identificacion = identificacion;
  }

  public ClienteUnico getClienteUnico() {
    return clienteUnico;
  }

  public void setClienteUnico(ClienteUnico clienteUnico) {
    this.clienteUnico = clienteUnico;
  }

  public List<Cuenta> getCuentas() {
    return cuentas;
  }

  public void setCuentas(List<Cuenta> cuentas) {
    this.cuentas = cuentas;
  }
}
