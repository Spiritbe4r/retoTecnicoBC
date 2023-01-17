package com.banco.comercio.apiblog.adapters.postgres.persistence;

import com.banco.comercio.apiblog.adapters.postgres.models.PostEntity;
import com.banco.comercio.apiblog.adapters.postgres.repository.PostRepository;
import com.banco.comercio.apiblog.domain.entities.Post;
import com.banco.comercio.apiblog.domain.persistence_ports.PostPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("postPersistence")
@RequiredArgsConstructor
public class PostPersistencePostgres implements PostPersistence {

    private final PostRepository postRepository;
    @Override
    public PostEntity create(PostEntity post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        var post = findById(id);
        postRepository.delete(post);
    }

    @Override
    public List<PostEntity> getAllByUser(String username) {
        return postRepository.getPostEntitiesByUser(username);
    }

    @Override
    public PostEntity findById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Override
    public PostEntity update(Long id ,PostEntity post) {
        var data = findById(id);

        return  postRepository.save(data);
    }


}
