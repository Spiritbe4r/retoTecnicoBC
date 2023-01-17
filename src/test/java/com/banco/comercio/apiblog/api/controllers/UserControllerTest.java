package com.banco.comercio.apiblog.api.controllers;

//import com.banco.comercio.apiblog.domain.repository.ClientRepository;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.postgres.persistence.UserPersistencePostgres;
import com.banco.comercio.apiblog.adapters.postgres.repository.UserRepository;
import com.banco.comercio.apiblog.adapters.rest.controllers.UserController;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.PostFacade;
import com.banco.comercio.apiblog.adapters.rest.facade.impl.PostFacadeImpl;
import com.banco.comercio.apiblog.domain.persistence_ports.UserPersistence;
import com.banco.comercio.apiblog.domain.service.PostService;
import com.banco.comercio.apiblog.domain.service.UserService;
import com.banco.comercio.apiblog.domain.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    private static UserRepository userRepository;

    private static UserPersistence userPersistence;
    private static UserPersistencePostgres userPersistencePostgres;

    private static PostService postService;
    private static UserService userService;
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private static final String BASE_URL = "http://localhost:8080/api/v1/users";
    private static final String TEST = "test";
    private static final String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb25hbGQiLCJpc3MiOiJyb25hbGQiLCJpYXQiOjE2NzM5MzgxODYsImp0aSI6ImEyOTEwYzk0LTMwYTQtNDI3OS1hYzRjLTNlNTEyNjFlNGIzMyIsImV4cCI6MTY3MzkzODQ4Niwicm9sZXMiOlsiUk9MRV9VU0VSIl0sInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.J1aDIcTVRSUztgCnUjPXZrYUiH2tqvu7L5OIdYfV8cM";

    @BeforeEach
    void setUp() {
        //userPersistencePostgres= mock(UserPersistencePostgres.class);


        userRepository = mock(UserRepository.class);
        //userPersistence= mock(UserPersistence.class);
        userPersistencePostgres = mock(UserPersistencePostgres.class);
        userPersistence = new UserPersistencePostgres(userRepository);

        userService = new UserServiceImpl(userPersistence);
        //postService = new PostServiceImpl(postPersistence, userPersistence);
        JacksonTester.initFields(this, new ObjectMapper());
        PostFacade postFacade = new PostFacadeImpl(postService, userService);
        UserController clientController = new UserController(postFacade, userService);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController)

                .build();

    }

    @Test
    void getClients() throws Exception {

        given(userRepository.findAll())
                .willReturn(List.of(getUserEntity()));

        MockHttpServletResponse response = mockMvc.perform(
                        get(BASE_URL + "/list")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    void deleteUserById() throws Exception {

        long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.of(getUserEntity()));
        doNothing().when(userRepository).deleteById(id);
        mockMvc.perform(delete(BASE_URL + "/{id}", id))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    CreateUserWebDTO getCreateUserWebDTO() {
        return CreateUserWebDTO.builder()
                .password(TEST)
                .cellPhone(TEST)
                .email(TEST)
                .name(TEST)
                .build();
    }


    UserEntity getUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername(TEST);
        userEntity.setPassword(TEST);

        return userEntity;
    }

    UserWebDTO getUserWebDTO() {

        return UserWebDTO.builder()
                .id(1L)
                .name(TEST).lastName(TEST).email(TEST).build();
    }

}
/*

    @Test
    void updateClient() throws Exception {

        long id = 1L;

        Client client = new Client(id, "Carlos", "Diaz", "Lima", "prueba@gmail.com", "3534543534");
        Client updatedClient = new Client(id, "Luis", "Diaz", "Lima", "prueba7@gmail.com", "23423424");

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(updatedClient);

        mockMvc.perform(put(BASE_URL + "/{id}", id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedClient)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(updatedClient.getName()))
                .andExpect(jsonPath("$.lastName").value(updatedClient.getLastName()))
                .andExpect(jsonPath("$.email").value(updatedClient.getEmail()))
                .andDo(print());
    }*/


