package com.banco.comercio.apiblog.adapters.rest.facade.impl;

import com.banco.comercio.apiblog.adapters.rest.dto.AuthResponse;
import com.banco.comercio.apiblog.adapters.rest.dto.LoginDto;
import com.banco.comercio.apiblog.adapters.rest.dto.UserDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.AuthFacade;
import com.banco.comercio.apiblog.domain.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthFacadeImpl implements AuthFacade {

    private final AuthService userService;

    @Override
    public UserResponseDTO createUser(UserDTO categoryDTO) {
        return userService.createUser(categoryDTO);
    }


    @Override
    public AuthResponse login(LoginDto loginDto) {
        return userService.login(loginDto);

    }
}