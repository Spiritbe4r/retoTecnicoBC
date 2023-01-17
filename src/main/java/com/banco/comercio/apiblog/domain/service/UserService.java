package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserWebDTO> findAll();
   /* Optional<UserWebDTO> findUserByUsername(String username);*/
    UserWebDTO createUser(CreateUserWebDTO clientWebDTO);

    UserWebDTO updateUser(Long id, CreateUserWebDTO clientWebDTO);

    Optional<UserWebDTO> findUserById(Long id);

    void deleteUser(Long id);


}
