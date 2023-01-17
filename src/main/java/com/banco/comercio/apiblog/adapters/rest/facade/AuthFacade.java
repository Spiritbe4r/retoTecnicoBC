package com.banco.comercio.apiblog.adapters.rest.facade;

import com.banco.comercio.apiblog.adapters.rest.dto.AuthResponse;
import com.banco.comercio.apiblog.adapters.rest.dto.LoginDto;
import com.banco.comercio.apiblog.adapters.rest.dto.UserDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;

public interface AuthFacade {
    UserResponseDTO createUser(UserDTO categoryDTO);

    AuthResponse login(LoginDto categoryDTO);
}
