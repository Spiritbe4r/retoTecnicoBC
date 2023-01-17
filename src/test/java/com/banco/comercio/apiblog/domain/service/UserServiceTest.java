package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.postgres.persistence.UserPersistencePostgres;
import com.banco.comercio.apiblog.adapters.postgres.repository.UserRepository;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.domain.persistence_ports.UserPersistence;
import com.banco.comercio.apiblog.domain.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
@SpringBootTest
class UserServiceTest {

    private static UserRepository userRepository;
    private static UserPersistencePostgres userPersistencePostgres;
    private static UserPersistence userPersistence;
    private static UserService userService;

    private static final String TEST = "test";


    @BeforeEach
    void setup() throws Exception {
        userRepository = mock(UserRepository.class);
        //userPersistence= mock(UserPersistence.class);
        userPersistencePostgres= mock(UserPersistencePostgres.class);
        userPersistence= new UserPersistencePostgres(userRepository);
        userService = new UserServiceImpl(userPersistence);
    }

    @Test
    @DisplayName("Deberia retornar una lista de todos los clientes")
    void findAll() {

        when(userRepository.findAll()).thenReturn(List.of(getUserEntity()));
        assertNotNull(userRepository.findAll());
        var result = userService.findAll();
        when(result).thenReturn(List.of(getUserWebDTO()));
        assertEquals(1, result.size());

    }

    UserEntity getUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("cardenascode7@gmail.com");
        userEntity.setUsername(TEST);
        userEntity.setPassword(TEST);

        return userEntity;
    }

    UserWebDTO getUserWebDTO(){

        return UserWebDTO.builder()
                .id(1L)
                .name(TEST).lastName(TEST).email("cardenascode7@gmail.com").build();
    }

    CreateUserWebDTO getCreateUserWebDTO(){

        return CreateUserWebDTO.builder()
                .name(TEST).lastName(TEST).email("cardenascode7@gmail.com").build();
    }
    @Test
    @DisplayName("Deberia guardar un usuario dentro de la bd")
    void createClient() {
        when(userRepository.save(Mockito.any())).thenReturn(getUserEntity());
        when(userPersistence.create(getUserEntity())).thenReturn(getUserEntity());
        when(userPersistencePostgres.create(getUserEntity())).thenReturn(getUserEntity());
        var userCreated = userService.createUser(getCreateUserWebDTO());
        when(userCreated).thenReturn(getUserWebDTO());
        assertNotNull(userCreated);
    }

    @Test
    @DisplayName("Deberia eliminar un cliente")
    void deleteUser() {

        final Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.of(getUserEntity()));
        userRepository.deleteById(id);
        userPersistence.delete(id);
        userPersistencePostgres.findById(id);
        userService.deleteUser(id);

        Mockito.verify(userRepository, times(1)).deleteById(id);
    }


}