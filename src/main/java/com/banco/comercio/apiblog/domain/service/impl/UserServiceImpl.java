package com.banco.comercio.apiblog.domain.service.impl;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
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
                        .email(x.getEmail())
                        .name(x.getName())
                        .roles(x.getRoles())
                        .build())
                .collect(Collectors.toList());
    }

    /*@Override
    public Optional<UserWebDTO> findUserByUsername(String username) {
        return userPersistence.findUserByUsername(username);
    }*/

    @Override
    public UserWebDTO createUser(CreateUserWebDTO createUserWebDTO) {
        UserEntity user = new UserEntity();
        user.setName(createUserWebDTO.getName());
        user.setCellPhone(createUserWebDTO.getCellPhone());
        user.setUsername(createUserWebDTO.getUsername());
        user.setPassword(createUserWebDTO.getPassword());

        return userPersistence.create(user).toUserWebDTO();
    }

    @Override
    public UserWebDTO updateUser(Long id, CreateUserWebDTO clientWebDTO) {

        var user = userPersistence.findById(id);
        user.setUsername(clientWebDTO.getUsername());
        user.setCellPhone(clientWebDTO.getCellPhone());
        return user.toUserWebDTO();
    }

    @Override
    public Optional<UserWebDTO> findUserById(Long id) {

        var user = userPersistence.findById(id);
        return Optional.of(user.toUserWebDTO());
    }

    @Override
    public void deleteUser(Long id) {
        userPersistence.delete(id);
    }

}
