package com.jwt.jwt.authentication;

import lombok.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
public class TokenProvider {


    private final String secret;
    private final Long expire;
    private final String issuer;

    public TokenProvider(
            @Value("${secret-key}") String secret,
            @Value("${expiration-hours}") long expire,
            @Value("${issuer}") String issuer
    )
}
