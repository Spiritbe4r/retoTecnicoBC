package com.banco.comercio.apiblog.adapters.postgres.repository;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUsername(String username);
    @Query(value = "SELECT ue FROM UserEntity ue  WHERE  ue.username = :username OR ue.email=:username")
    Optional<UserEntity> findByEmail(String username);
}
