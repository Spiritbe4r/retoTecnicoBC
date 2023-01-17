package com.banco.comercio.apiblog.domain.service.impl;

import com.banco.comercio.apiblog.adapters.postgres.models.PostEntity;
import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.domain.entities.Post;
import com.banco.comercio.apiblog.domain.persistence_ports.PostPersistence;
import com.banco.comercio.apiblog.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostPersistence postPersistence;

    @Override
    public List<Post> findAll() {
        return postPersistence.getAll().stream()
                .map(PostEntity::toPost).toList();


    }

    @Override
    public Post createPost(CreatePostWebDTO postWebDTO) {
        var post = PostEntity.builder()
                .title(postWebDTO.title())
                .content(postWebDTO.content()).build();
        return postPersistence.create(post).toPost();
    }

    @Override
    public Post updatePost(Long id, CreatePostWebDTO postWebDTO) {
        var post = postPersistence.findById(id);
        post.setTitle(postWebDTO.title());
        post.setContent(postWebDTO.content());
        return postPersistence.create(post).toPost();
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        return Optional.of(postPersistence.findById(id).toPost());
    }

    @Override
    public void deletePost(Long id) {
        postPersistence.delete(id);
    }
}
