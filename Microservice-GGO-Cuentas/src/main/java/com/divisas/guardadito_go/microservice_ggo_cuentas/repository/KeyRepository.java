package com.divisas.guardadito_go.microservice_ggo_cuentas.repository;

import com.divisas.guardadito_go.microservice_ggo_cuentas.model.SecurityKey;
import java.util.Optional;

public interface KeyRepository {

  Optional<SecurityKey> findByXIdAcceso(String xIdAcceso);

  void save(SecurityKey securityKey);

  void deleteByXIdAcceso(String xIdAcceso);
}
