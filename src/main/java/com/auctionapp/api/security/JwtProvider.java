package com.auctionapp.api.security;

import static io.jsonwebtoken.Jwts.parserBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;

import com.auctionapp.api.exceptions.SpringAuctionException;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtProvider {

    private KeyStore keyStore;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new SpringAuctionException("Exception occured while loading keystore");
        }
    }

    public String generateToken(final Authentication authentication) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) 
        authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(principal
                .getUsername())
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringAuctionException("Exception occured while retrieving public key from keystore");
        }
    }

    public boolean validateToken(final String jwt) {
        parserBuilder()
            .setSigningKey(getPublicKey())
            .build()
            .parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringAuctionException("Exception occured while retrieving public keys");
        }
    }

    public String getUsernameFromJwt(final String token) {
        Claims claims = parserBuilder()
                            .setSigningKey(getPublicKey())
                            .build()
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject();
    }
}
