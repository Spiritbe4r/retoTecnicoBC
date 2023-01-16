package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.rest.dto.ClientWebDTO;
import com.banco.comercio.apiblog.domain.service.impl.UserServiceImpl;
import com.banco.comercio.apiblog.domain.dto.ClientDTO;
import com.banco.comercio.apiblog.domain.entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    /*private static ClientRepository clientRepository;
    private static UserService userService;

    private static final String TEST = "test";


    @BeforeEach
    void setup() throws Exception {
        clientRepository = mock(ClientRepository.class);
        userService = new UserServiceImpl(clientRepository);
    }

    @Test
    @DisplayName("Deberia retornar una lista de todos los clientes")
    void findAll() {

        when(clientRepository.findAll()).thenReturn(List.of(getClient()));
        assertNotNull(clientRepository.findAll());
        var result = userService.findAll();
        when(result).thenReturn(List.of(getClientDto()));
        assertEquals(1, result.size());

    }

    @Test
    @DisplayName("Deberia guardar un cliente dentro de la bd")
    void createClient() {
        when(clientRepository.save(Mockito.any())).thenReturn(getClient());
        when(userService.createClient(getClientWebDto())).thenReturn(getClientDto());
    }

    @Test
    @DisplayName("Deberia actualizar los datos de un cliente")
    void updateClient() {
        var client = getClient();

        when(clientRepository.findById(client.getId()))
                .thenReturn(Optional.of(client));

        ArgumentCaptor<Client> clientArgument =
                ArgumentCaptor.forClass(Client.class);

        when(clientRepository.save(clientArgument.capture()))
                .thenAnswer(iom -> iom.getArgument(0));


        ClientWebDTO priceRequest = new ClientWebDTO();
        priceRequest.setEmail("cardenascode7@outlook.com");

        userService.updateClient(client.getId(), priceRequest);


        Assertions.assertEquals(clientArgument.getValue().getEmail(), "cardenascode7@outlook.com");

    }

    @Test
    @DisplayName("Deberia retornar un client por id")
    void findClientById() {

        Long clientId = 1L;
        var clientMock = getClient();
        doReturn(Optional.of(clientMock)).when(clientRepository).findById(clientId);

        Optional<ClientDTO> e1ByService = userService.findClientById(clientMock.getId());

        assertNotNull(e1ByService, "Client with ID : " + clientId + " not found");
        assertEquals(clientId, e1ByService.get().getId());
    }

    @Test
    @DisplayName("Deberia eliminar un cliente")
    void deleteClient() {

        final Long id = 1L;

        userService.deleteClient(id);

        Mockito.verify(clientRepository).deleteById(id);
    }

    ClientDTO getClientDto() {
        return ClientDTO.builder()
                .id(1L)
                .email(TEST)
                .cellPhone(TEST)
                .lastName(TEST)
                .name(TEST).build();
    }

    ClientWebDTO getClientWebDto() {
        return ClientWebDTO.builder()
                .email(TEST)
                .cellPhone(TEST)
                .lastName(TEST)
                .name(TEST).build();
    }

    Client getClient() {
        Client client = new Client();
        client.setId(1L);
        client.setEmail("cardenascode7@gmail.com");
        client.setLastName(TEST);
        client.setName(TEST);
        client.setCellPhone(TEST);
        client.setAddress(TEST);
        return client;
    }*/
}