package com.banco.comercio.apiblog.domain.service.impl;

import com.banco.comercio.apiblog.adapters.postgres.models.PostEntity;
import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.domain.entities.Post;
import com.banco.comercio.apiblog.domain.persistence_ports.PostPersistence;
import com.banco.comercio.apiblog.domain.persistence_ports.UserPersistence;
import com.banco.comercio.apiblog.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostPersistence postPersistence;

    private final UserPersistence userPersistence;

    @Override
    public List<Post> findAll(String username) {
        return postPersistence.getAllByUser(username).stream()
                .map(PostEntity::toPost).toList();


    }

    @Override
    public Post createPost(String username, CreatePostWebDTO postWebDTO) {
        var user = userPersistence.findUserByUsername(username);
        var post = PostEntity.builder()
                .title(postWebDTO.title())
                .user(user.orElse(new UserEntity()))
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
    public Optional<Post> findPostById(Long id,String username) {
        return postPersistence.getAllByUser(username)
                        .stream().filter(x->x.getId().equals(id)).map(PostEntity::toPost).findFirst();
    }

    @Override
    public void deletePost(Long id) {
        postPersistence.delete(id);
    }
}
