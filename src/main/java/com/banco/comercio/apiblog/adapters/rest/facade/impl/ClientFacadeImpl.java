package com.banco.comercio.apiblog.adapters.rest.facade.impl;

import com.banco.comercio.apiblog.adapters.rest.facade.ClientFacade;
import com.banco.comercio.apiblog.adapters.rest.dto.ClientWebDTO;
import com.banco.comercio.apiblog.domain.dto.ClientDTO;
import com.banco.comercio.apiblog.domain.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class ClientFacadeImpl implements ClientFacade {

    private final UserService userService;

    public ClientFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    /*@Override
    public List<ClientDTO> findAll() {
        return userService.findAll();
    }

    @Override
    public ClientDTO createClient(ClientWebDTO clientWebDTO) {
        return userService.createClient(clientWebDTO);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientWebDTO clientWebDTO) {
        return userService.updateClient(id, clientWebDTO);
    }

    @Override
    public Optional<ClientDTO> findClientById(Long id) {
        return userService.findClientById(id);
    }

    @Override
    public void deleteClient(Long id) {
        userService.deleteClient(id);
    }*/
}
