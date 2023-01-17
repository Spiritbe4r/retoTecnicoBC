package com.banco.comercio.apiblog.adapters.rest.facade.impl;

import com.banco.comercio.apiblog.adapters.rest.dto.AuthResponse;
import com.banco.comercio.apiblog.adapters.rest.dto.LoginDto;
import com.banco.comercio.apiblog.adapters.rest.dto.UserDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.UserFacade;
import com.banco.comercio.apiblog.domain.service.AuthService;
import com.banco.comercio.apiblog.domain.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacadeImpl implements UserFacade {

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