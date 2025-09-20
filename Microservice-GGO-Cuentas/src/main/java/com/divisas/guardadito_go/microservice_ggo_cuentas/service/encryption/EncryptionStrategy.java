package com.divisas.guardadito_go.microservice_ggo_cuentas.service.encryption;

public interface EncryptionStrategy {
    
    String encrypt(String data, String publicKey);
    
    String decrypt(String encryptedData, String privateKey);
    
    String getAlgorithmName();
}
