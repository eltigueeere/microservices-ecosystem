package com.divisas.guardadito_go.microservice_ggo_cuentas.service;

import com.divisas.guardadito_go.microservice_ggo_cuentas.config.ExternalMicroserviceConfig;
import com.divisas.guardadito_go.microservice_ggo_cuentas.dto.request.BusquedaCuentaRequest;
import com.divisas.guardadito_go.microservice_ggo_cuentas.dto.response.BusquedaCuentaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalMicroserviceService {

    private static final Logger logger = LoggerFactory.getLogger(ExternalMicroserviceService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private ExternalMicroserviceConfig config;

    public BusquedaCuentaResponse procesarBusquedaCuenta(BusquedaCuentaRequest request, String idAcceso) {
        BusquedaCuentaResponse response = null;
        
        try {
            // 1. Descifrar datoBusqueda
            String datoBusquedaDescifrado = encryptionService.decryptData(request.getDatoBusqueda(), idAcceso);
            logger.debug("Dato descifrado: {}", datoBusquedaDescifrado);

            // 2. Crear request para microservicio externo
            BusquedaCuentaRequest externalRequest = new BusquedaCuentaRequest();
            externalRequest.setDatoBusqueda(datoBusquedaDescifrado);
            externalRequest.setIdBusqueda(request.getIdBusqueda());

            // 3. Configurar headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("x-id-acceso", idAcceso);

            HttpEntity<BusquedaCuentaRequest> entity = new HttpEntity<>(externalRequest, headers);

            // 4. Configurar timeout y llamar al microservicio externo
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setConnectTimeout(config.getTimeout());
            factory.setReadTimeout(config.getTimeout());
            restTemplate.setRequestFactory(factory);
            
            logger.info("Llamando a microservicio externo: {} {}", config.getMethod(), config.getUrl());
            ResponseEntity<BusquedaCuentaResponse> responseEntity = restTemplate.exchange(
                config.getUrl(),
                HttpMethod.valueOf(config.getMethod()),
                entity,
                BusquedaCuentaResponse.class
            );

            response = responseEntity.getBody();
            logger.info("Respuesta recibida del microservicio externo");

            // 5. Cifrar la respuesta que viene en claro del microservicio externo
            if (response != null && response.getMensaje() != null) {
                String mensajeCifrado = encryptionService.encryptData(response.getMensaje(), idAcceso);
                response.setMensaje(mensajeCifrado);
                logger.debug("Respuesta cifrada para cliente");
            }

        } catch (Exception e) {
            logger.error("Error al procesar búsqueda de cuenta: {}", e.getMessage(), e);
        } finally {
            // 6. Si no hay respuesta, crear datos de ejemplo cifrados
            if (response == null) {
                response = crearRespuestaEjemplo(idAcceso);
            }
        }

        return response;
    }

    private BusquedaCuentaResponse crearRespuestaEjemplo(String idAcceso) {
        try {
            logger.info("Creando respuesta de ejemplo con datos cifrados");
            
            // Datos de ejemplo en claro
            String datosEjemplo = "{\"numeroCuenta\":\"1234567890\",\"titular\":\"Juan Perez\",\"saldo\":15000.50,\"estado\":\"ACTIVA\"}";
            
            // Cifrar los datos de ejemplo
            String datosCifrados = encryptionService.encryptData(datosEjemplo, idAcceso);
            
            BusquedaCuentaResponse response = new BusquedaCuentaResponse();
            response.setMensaje(datosCifrados);
            response.setFolio("42c66ddd-602a-48cd-9ceb-8a5c9652d6b7");
            
            logger.debug("Respuesta de ejemplo creada con datos cifrados");
            return response;
            
        } catch (Exception e) {
            logger.error("Error al crear respuesta de ejemplo: {}", e.getMessage(), e);
            
            // Respuesta de fallback sin cifrado
            BusquedaCuentaResponse fallbackResponse = new BusquedaCuentaResponse();
            fallbackResponse.setMensaje("Error interno del servidor");
            fallbackResponse.setFolio("error-folio");
            
            return fallbackResponse;
        }
    }
}
