package com.banco.comercio.apiblog.domain.persistence_ports;


import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.domain.dto.UserDTO;
import com.banco.comercio.apiblog.domain.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPersistence {
    UserEntity create(UserEntity user);

    List<UserEntity> getAll();

    void delete(Long id);

    UserEntity findById(Long id);

    UserEntity update(Long Id,UserEntity user);

    Optional<UserEntity> findUserByUsername(String username);
}
