package com.banco.comercio.apiblog.adapters.rest.controllers;

import com.banco.comercio.apiblog.adapters.rest.dto.AuthResponse;
import com.banco.comercio.apiblog.adapters.rest.dto.LoginDto;
import com.banco.comercio.apiblog.adapters.rest.dto.UserDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.AuthFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private final AuthFacade authFacade;

    public AuthController(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO categoryDTO) {
        var result = authFacade.createUser(categoryDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto categoryDTO) {
        var result = authFacade.login(categoryDTO);
        return ResponseEntity.ok().body(result);
    }
}