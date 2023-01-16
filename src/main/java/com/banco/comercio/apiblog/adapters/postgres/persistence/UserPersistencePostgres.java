package com.banco.comercio.apiblog.adapters.postgres.persistence;

import com.banco.comercio.apiblog.adapters.postgres.models.PostEntity;
import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.postgres.repository.PostRepository;
import com.banco.comercio.apiblog.adapters.postgres.repository.UserRepository;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.domain.dto.UserDTO;
import com.banco.comercio.apiblog.domain.entities.User;
import com.banco.comercio.apiblog.domain.persistence_ports.PostPersistence;
import com.banco.comercio.apiblog.domain.persistence_ports.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userPersistence")
@RequiredArgsConstructor
public class UserPersistencePostgres implements UserPersistence {

    private final UserRepository userRepository;
    @Override
    public UserEntity create(UserEntity user) {
            /*var data = CreateUserWebDTO.builder()
                    .name(post.getName())
                    .lastName(post.getLastName())
                    .password(post.getPassword())
                    .username(post.getUsername()).build();*/

        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        var user = findById(id);
        userRepository.delete(user);
    }

    @Override
    public UserEntity findById(Long id) {

        return  userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserEntity update(Long id, UserEntity user) {
        var data = findById(id);
        return userRepository.save(data);
    }


}
