package com.example.onlineServiceProvider.service.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class Jwt {

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
    }
}
