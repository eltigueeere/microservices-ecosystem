package com.divisas.guardadito_go.microservice_ggo_cuentas.repository.impl;

import com.divisas.guardadito_go.microservice_ggo_cuentas.model.SecurityKey;
import com.divisas.guardadito_go.microservice_ggo_cuentas.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisKeyRepository implements KeyRepository {
    
    private static final String KEY_PREFIX = "security_key:";
    private static final String PUBLIC_KEY_SUFFIX = ":public";
    private static final String PRIVATE_KEY_SUFFIX = ":private";
    private static final long TTL_HOURS = 24;
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Override
    public Optional<SecurityKey> findByXIdAcceso(String xIdAcceso) {
        String publicKeyRedisKey = KEY_PREFIX + xIdAcceso + PUBLIC_KEY_SUFFIX;
        String privateKeyRedisKey = KEY_PREFIX + xIdAcceso + PRIVATE_KEY_SUFFIX;
        
        String publicKey = redisTemplate.opsForValue().get(publicKeyRedisKey);
        String privateKey = redisTemplate.opsForValue().get(privateKeyRedisKey);
        
        if (publicKey != null && privateKey != null) {
            return Optional.of(new SecurityKey(publicKey, privateKey, xIdAcceso));
        }
        
        return Optional.empty();
    }
    
    @Override
    public void save(SecurityKey securityKey) {
        String publicKeyRedisKey = KEY_PREFIX + securityKey.getXIdAcceso() + PUBLIC_KEY_SUFFIX;
        String privateKeyRedisKey = KEY_PREFIX + securityKey.getXIdAcceso() + PRIVATE_KEY_SUFFIX;
        
        redisTemplate.opsForValue().set(publicKeyRedisKey, securityKey.getPublicKey(), TTL_HOURS, TimeUnit.HOURS);
        redisTemplate.opsForValue().set(privateKeyRedisKey, securityKey.getPrivateKey(), TTL_HOURS, TimeUnit.HOURS);
    }
    
    @Override
    public void deleteByXIdAcceso(String xIdAcceso) {
        String publicKeyRedisKey = KEY_PREFIX + xIdAcceso + PUBLIC_KEY_SUFFIX;
        String privateKeyRedisKey = KEY_PREFIX + xIdAcceso + PRIVATE_KEY_SUFFIX;
        
        redisTemplate.delete(publicKeyRedisKey);
        redisTemplate.delete(privateKeyRedisKey);
    }
}
