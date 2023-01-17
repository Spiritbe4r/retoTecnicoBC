package com.banco.comercio.apiblog.adapters.rest.controllers;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.postgres.persistence.UserPersistencePostgres;
import com.banco.comercio.apiblog.adapters.postgres.repository.UserRepository;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.impl.AuthFacadeImpl;
import com.banco.comercio.apiblog.domain.persistence_ports.UserPersistence;
import com.banco.comercio.apiblog.domain.service.AuthService;
import com.banco.comercio.apiblog.domain.service.UserService;
import com.banco.comercio.apiblog.domain.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthControllerTest {

    private static UserRepository userRepository;
    private static UserPersistencePostgres userPersistencePostgres;
    private static UserPersistence userPersistence;

    private static AuthService authService;
    private static UserService userService;
    private MockMvc mockMvc;
    private static final String TEST = "test";
    @BeforeEach
    void setUp() {

        userRepository = mock(UserRepository.class);
        userPersistence= mock(UserPersistence.class);
        userPersistencePostgres= mock(UserPersistencePostgres.class);
        userPersistence= new UserPersistencePostgres(userRepository);
        userService = new UserServiceImpl(userPersistence);

    }

    @Test
    void createClient() throws Exception {
        when(userRepository.save(Mockito.any())).thenReturn(getUserEntity());
        when(userPersistence.create(getUserEntity())).thenReturn(getUserEntity());
        when(userPersistencePostgres.create(getUserEntity())).thenReturn(getUserEntity());
        var userCreated = userService.createUser(getCreateUserWebDTO());
        when(userCreated).thenReturn(getUserWebDTO());
        assertNotNull(userCreated);
    }

    @Test
    void login() {
    }
    UserEntity getUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername(TEST);
        userEntity.setPassword(TEST);

        return userEntity;
    }

    UserWebDTO getUserWebDTO(){

        return UserWebDTO.builder()
                .id(1L)
                .name(TEST).lastName(TEST).email(TEST).build();
    }

    CreateUserWebDTO getCreateUserWebDTO(){

        return CreateUserWebDTO.builder()
                .password(TEST)
                .name(TEST).lastName(TEST).email(TEST).build();
    }
}