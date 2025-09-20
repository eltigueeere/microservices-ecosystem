package com.divisas.crud_cuentas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.divisas.crud_cuentas.model.CuentaTB;

// @Repository esto gracias a spring boot no es necesario
public interface CuentaRepository extends JpaRepository<CuentaTB, Long> {

    List<CuentaTB> findByCuenta(String cuenta);

    List<CuentaTB> findByIdCuentas(Long idCuentas);


}