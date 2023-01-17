package com.banco.comercio.apiblog.adapters.rest.facade.impl;

import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.PostFacade;
import com.banco.comercio.apiblog.domain.entities.Post;
import com.banco.comercio.apiblog.domain.service.PostService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostFacadeImpl implements PostFacade {

        private final PostService postService;

    public PostFacadeImpl(PostService postService) {
        this.postService = postService;
    }


    @Override
    public List<PostWebDTO> findAll() {
        return postService.findAll().stream()
                .map(Post::toPostWebDTO).collect(Collectors.toList());
    }

    @Override
    public PostWebDTO createPost(CreatePostWebDTO createPostWebDTO) {
        return postService.createPost(createPostWebDTO).toPostWebDTO();
    }

    @Override
    public PostWebDTO updatePost(Long id, CreatePostWebDTO clientWebDTO) {
        return postService.updatePost(id, clientWebDTO).toPostWebDTO();
    }

    @Override
    public Optional<PostWebDTO> findPostById(Long id) {
        return postService.findPostById(id).map(Post::toPostWebDTO);
    }

    @Override
    public void deletePost(Long id) {
        postService.deletePost(id);
    }

}
