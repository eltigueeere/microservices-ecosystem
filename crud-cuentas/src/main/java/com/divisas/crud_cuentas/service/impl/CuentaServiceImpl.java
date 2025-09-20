package com.divisas.crud_cuentas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.divisas.crud_cuentas.dto.CuentasRequest;
import com.divisas.crud_cuentas.dto.CuentasResponse;
import com.divisas.crud_cuentas.model.CuentaTB;
import com.divisas.crud_cuentas.repository.CuentaRepository;
import com.divisas.crud_cuentas.service.ICuentaService;

@Service
public class CuentaServiceImpl implements ICuentaService {

    private final CuentaRepository cuentaRepository;

    final static Logger logger = LoggerFactory.getLogger(CuentaServiceImpl.class);


    public CuentaServiceImpl(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }


    // Insertar cuenta

    @Override
    public CuentasResponse insertCuenta(CuentasRequest cuentasRequest){
        CuentasResponse cuentasResponse = new CuentasResponse();
        try {
            if( !cuentaRepository.findByCuenta(cuentasRequest.getCuenta()).isEmpty() ){
                logger.info("La cuenta " + cuentasRequest.getCuenta() + " ya existe");
                cuentasResponse.setMensaje("La cuenta " + cuentasRequest.getCuenta() + " ya existe");
                return cuentasResponse;
            } else {
                logger.info("insertando la cuenta " + cuentasRequest.getCuenta());
                String description = (cuentasRequest.getDescription() == null || cuentasRequest.getDescription().isEmpty()) 
                    ? "Descripción por defecto" : cuentasRequest.getDescription();
                CuentaTB nuevaCuenta = new CuentaTB(cuentasRequest.getCuenta(), description);
                cuentaRepository.save(nuevaCuenta);
                logger.info("cuenta guardada");
                cuentasResponse.setMensaje("La cuenta " + cuentasRequest.getCuenta() + " se inserto correcto");
                return cuentasResponse;
            }
        } catch (DataAccessException e) {
            logger.error("Error al insertar cuenta: " + cuentasRequest.getCuenta(), e);
            cuentasResponse.setMensaje("Error al procesar la cuenta");
            return cuentasResponse;
        }
    }


    // Leer todo 
    @Override
    public List<CuentasResponse> getCuentas() {
        try {
            return cuentaRepository.findAll()
                    .stream()
                    .map(this::convertirADto)
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            logger.error("Error al obtener cuentas", e);
            return new ArrayList<>();
        }
    }

    private CuentasResponse convertirADto(CuentaTB cuenta) {
        CuentasResponse dto = new CuentasResponse();
        dto.setCuenta(cuenta.getCuenta());
        dto.setMensaje(cuenta.getDescription());
        return dto;
    }


}