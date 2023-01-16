package com.banco.comercio.apiblog.adapters.postgres.repository;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
