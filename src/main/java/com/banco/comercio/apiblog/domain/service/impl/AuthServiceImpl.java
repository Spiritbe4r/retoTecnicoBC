package com.banco.comercio.apiblog.domain.service.impl;


import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.postgres.repository.UserRepository;
import com.banco.comercio.apiblog.adapters.rest.dto.AuthResponse;
import com.banco.comercio.apiblog.adapters.rest.dto.LoginDto;
import com.banco.comercio.apiblog.adapters.rest.dto.UserDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;
import com.banco.comercio.apiblog.config.enums.UserRoles;
import com.banco.comercio.apiblog.config.jwt.JwtService;
import com.banco.comercio.apiblog.domain.service.AuthService;
import com.banco.comercio.apiblog.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;



    @Override
    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public UserResponseDTO createUser(UserDTO createUserDTO) {
        var user = UserEntity.builder().name(createUserDTO.getName())
                .name(createUserDTO.getName())
                .lastName(createUserDTO.getLastName())
                .email(createUserDTO.getEmail())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .roles(List.of(UserRoles.ROLE_USER))
                .build();
        return userRepository.save(user).toUserResponseDTO();
    }

    @Override
    public UserResponseDTO findUserByUsername(String username) {
        return userRepository.findByUsername(username).map(UserEntity::toUserResponseDTO).orElse(null);
    }

    @Override
    public AuthResponse login(LoginDto loginDto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password()));

        UserEntity userDetails = userRepository.findByEmail(loginDto.email()).orElseThrow();
        String jwtToken = jwtService.generateJwtToken(userDetails);
        return AuthResponse.builder().authToken(jwtToken).build();
    }
}
