package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.rest.dto.AuthResponse;
import com.banco.comercio.apiblog.adapters.rest.dto.LoginDto;
import com.banco.comercio.apiblog.adapters.rest.dto.UserDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;


public interface AuthService {

    UserEntity getByUsername(String username);

    UserResponseDTO createUser(UserDTO createUserDTO);

    UserResponseDTO findUserByUsername(String username);


    AuthResponse login(LoginDto user);
}
