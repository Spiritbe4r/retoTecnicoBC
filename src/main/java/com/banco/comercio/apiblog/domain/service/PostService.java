package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.rest.dto.ClientWebDTO;
import com.banco.comercio.apiblog.domain.dto.ClientDTO;
import com.banco.comercio.apiblog.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<User> findAll();

    User createClient(ClientWebDTO clientWebDTO);

    User updateClient(Long id, ClientWebDTO clientWebDTO);

    Optional<User> findClientById(Long id);

    void deleteClient(Long id);


}
