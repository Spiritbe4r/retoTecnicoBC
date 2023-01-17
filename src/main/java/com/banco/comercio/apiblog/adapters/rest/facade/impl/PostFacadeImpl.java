package com.banco.comercio.apiblog.adapters.rest.facade.impl;

import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.PostFacade;
import com.banco.comercio.apiblog.domain.entities.Post;
import com.banco.comercio.apiblog.domain.service.PostService;
import com.banco.comercio.apiblog.domain.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostFacadeImpl implements PostFacade {

        private final PostService postService;
        private final UserService userService;

    public PostFacadeImpl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }


    @Override
    public List<PostWebDTO> findPostsByUser(String username) {
        return postService.findAll(username).stream()
                .map(Post::toPostWebDTO).collect(Collectors.toList());
    }

    @Override
    public PostWebDTO createPost(String username , CreatePostWebDTO createPostWebDTO) {
        //var user = userService.findUserByUsername(username);
        return postService.createPost(username,createPostWebDTO).toPostWebDTO();
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
