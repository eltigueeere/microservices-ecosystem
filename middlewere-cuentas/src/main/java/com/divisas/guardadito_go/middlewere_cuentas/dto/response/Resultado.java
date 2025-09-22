package com.divisas.guardadito_go.middlewere_cuentas.dto.response;

public class Resultado {

  private Boolean clienteRegistrado;
  private Cliente cliente;

  public Boolean getClienteRegistrado() {
    return clienteRegistrado;
  }

  public void setClienteRegistrado(Boolean clienteRegistrado) {
    this.clienteRegistrado = clienteRegistrado;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
