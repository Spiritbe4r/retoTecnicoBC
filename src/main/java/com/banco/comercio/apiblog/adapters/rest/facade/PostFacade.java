package com.banco.comercio.apiblog.adapters.rest.facade;

import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;

import java.util.List;
import java.util.Optional;

public interface PostFacade {

    List<PostWebDTO> findPostsByUser(String username);

    PostWebDTO createPost(String username , CreatePostWebDTO createPostWebDTO);

    PostWebDTO updatePost(Long id ,CreatePostWebDTO clientWebDTO);

    Optional<PostWebDTO> findPostById(Long id);

    void deletePost(Long id);
}
