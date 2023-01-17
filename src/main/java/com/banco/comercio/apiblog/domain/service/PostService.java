package com.banco.comercio.apiblog.domain.service;

import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.domain.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();

    Post createPost(CreatePostWebDTO postWebDTO);

    Post updatePost(Long id, CreatePostWebDTO postWebDTO);

    Optional<Post> findPostById(Long id);

    void deletePost(Long id);



}
