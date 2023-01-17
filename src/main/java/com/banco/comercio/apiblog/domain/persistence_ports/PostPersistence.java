package com.banco.comercio.apiblog.domain.persistence_ports;


import com.banco.comercio.apiblog.adapters.postgres.models.PostEntity;
import com.banco.comercio.apiblog.domain.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostPersistence {
    PostEntity create(PostEntity classification);

    void delete(Long id);
    List<PostEntity> getAllByUser(String username);

    PostEntity findById(Long id);
    PostEntity update(Long id, PostEntity classification);
}
