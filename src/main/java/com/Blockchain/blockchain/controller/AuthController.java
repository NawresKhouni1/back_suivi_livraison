package com.Blockchain.blockchain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blockchain.blockchain.dto.ReqRes;
import com.Blockchain.blockchain.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    
   
    // Endpoint pour l'inscription
    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signUpRequest) {
        ReqRes response = authService.signUp(signUpRequest);
        if (response.getStatusCode() == 200) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(500).body(response);
        }
    }

    // Endpoint pour la connexion
    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signInRequest) {
        ReqRes response = authService.signIn(signInRequest);
        if (response.getStatusCode() == 200) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(response); // Code 401 pour une authentification échouée
        }
    }
}
