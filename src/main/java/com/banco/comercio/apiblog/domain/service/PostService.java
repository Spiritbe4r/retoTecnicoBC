package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.domain.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll(String username);

    Post createPost(String username, CreatePostWebDTO postWebDTO);

    Post updatePost(Long id, CreatePostWebDTO postWebDTO,String username);

    Optional<Post> findPostById(Long id, String username);

    void deletePost(Long id);



}
