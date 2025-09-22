package com.divisas.guardadito_go.microservice_ggo_cuentas.service;

import com.divisas.guardadito_go.microservice_ggo_cuentas.model.SecurityKey;
import com.divisas.guardadito_go.microservice_ggo_cuentas.repository.KeyRepository;
import com.divisas.guardadito_go.microservice_ggo_cuentas.service.encryption.EncryptionStrategy;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

  @Autowired private KeyRepository keyRepository;

  @Autowired private EncryptionStrategy encryptionStrategy;

  public String encryptData(String data, String xIdAcceso) {
    Optional<SecurityKey> securityKey = keyRepository.findByXIdAcceso(xIdAcceso);

    if (securityKey.isEmpty()) {
      throw new RuntimeException("Security key not found for x-id-acceso: " + xIdAcceso);
    }

    return encryptionStrategy.encrypt(data, securityKey.get().getPublicKey());
  }

  public String decryptData(String encryptedData, String xIdAcceso) {
    Optional<SecurityKey> securityKey = keyRepository.findByXIdAcceso(xIdAcceso);

    if (securityKey.isEmpty()) {
      throw new RuntimeException("Security key not found for x-id-acceso: " + xIdAcceso);
    }

    return encryptionStrategy.decrypt(encryptedData, securityKey.get().getPrivateKey());
  }

  public void storeSecurityKey(SecurityKey securityKey) {
    keyRepository.save(securityKey);
  }
}
