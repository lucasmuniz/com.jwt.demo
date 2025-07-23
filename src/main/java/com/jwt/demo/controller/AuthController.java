package com.jwt.demo.controller;

import com.jwt.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider tokenProvider;

    public AuthController(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String senha) {
        // Simula autenticação
        if ("123".equals(senha)) {
            String token = tokenProvider.generateToken(username);
            return Map.of("token", token);
        }
        throw new RuntimeException("Login inválido");
    }
}