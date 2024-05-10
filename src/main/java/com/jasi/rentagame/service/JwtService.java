package com.jasi.rentagame.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jasi.rentagame.dto.LoginRequestBody;
import com.jasi.rentagame.util.JwtUtils;

@Service
public class JwtService {
    @Autowired
    private JwtUtils jwtUtils;

    public String generateToken(LoginRequestBody loginRequestBody) {
        String username = Base64.getEncoder().encodeToString(loginRequestBody.getUsername().getBytes());
        String password = Base64.getEncoder().encodeToString(loginRequestBody.getPassword().getBytes());
        return jwtUtils.generateToken(username, password);
    }

    public DecodedJWT validatesToken(String token) {
        return jwtUtils.validatesToken(token);
    }

    public String getUsername(DecodedJWT decodedJWT) {
        return jwtUtils.getUsername(decodedJWT);
    }

    public String getAuthorities(DecodedJWT decodedJWT) {
        return jwtUtils.getAuthorities(decodedJWT);
    }
}
