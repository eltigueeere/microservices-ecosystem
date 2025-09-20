package com.divisas.guardadito_go.microservice_ggo_cuentas.model;

public class SecurityKey {
    
    private String publicKey;
    private String privateKey;
    private String xIdAcceso;
    
    public SecurityKey() {}
    
    public SecurityKey(String publicKey, String privateKey, String xIdAcceso) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.xIdAcceso = xIdAcceso;
    }
    
    public String getPublicKey() {
        return publicKey;
    }
    
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    public String getPrivateKey() {
        return privateKey;
    }
    
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
    
    public String getXIdAcceso() {
        return xIdAcceso;
    }
    
    public void setXIdAcceso(String xIdAcceso) {
        this.xIdAcceso = xIdAcceso;
    }
}
