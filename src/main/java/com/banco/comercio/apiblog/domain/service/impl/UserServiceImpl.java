package com.banco.comercio.apiblog.domain.service.impl;

import com.banco.comercio.apiblog.adapters.rest.dto.ClientWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.domain.dto.ClientDTO;
import com.banco.comercio.apiblog.domain.entities.Client;
import com.banco.comercio.apiblog.domain.entities.User;
import com.banco.comercio.apiblog.domain.exception.NotFoundException;
import com.banco.comercio.apiblog.domain.persistence_ports.UserPersistence;
import com.banco.comercio.apiblog.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserPersistence userPersistence;


    @Override
    public List<UserWebDTO> findAll() {
        return userPersistence.getAll().stream()
                .map(x->UserWebDTO.builder().username(x.getUsername())
                        .cellPhone(x.getCellPhone())
                        .lastName(x.getLastName())
                        .name(x.getName()).build())
                .collect(Collectors.toList());
    }

    @Override
    public UserWebDTO createClient(CreateUserWebDTO clientWebDTO) {
        return userPersistence.create(clientWebDTO);
    }

    /*@Override
    public ClientWebDTO createClient(ClientWebDTO clientWebDTO) {
        var client = Client.builder().address(clientWebDTO.getAddress())
                .email(clientWebDTO.getEmail())
                .cellPhone(clientWebDTO.getCellPhone())
                .name(clientWebDTO.getName())
                .lastName(clientWebDTO.getLastName()).build();


        return Client.toCreateClientDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO updateClient(Long id ,ClientWebDTO clientWebDTO) {

        var clientOpt = clientRepository.findById(id).orElseThrow(()-> new NotFoundException("Client not found with this Id : " + id));

            clientOpt.setName(clientWebDTO.getName());
            clientOpt.setCellPhone(clientWebDTO.getCellPhone());
            clientOpt.setLastName(clientWebDTO.getLastName());
            clientOpt.setEmail(clientWebDTO.getEmail());

        return Client.toClientDTO(clientRepository.save(clientOpt));
    }

    @Override
    public Optional<ClientDTO> findClientById(Long id) {
        var client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new NotFoundException("Client with this id : " + id + " not found");
        }
        return Optional.ofNullable(Client.toClientDTO(client.get()));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }*/
}
