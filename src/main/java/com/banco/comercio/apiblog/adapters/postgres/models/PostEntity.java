package com.banco.comercio.apiblog.adapters.postgres.models;

import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.domain.entities.Post;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity extends BaseEntity {

    private String title;
    private String content;

    @ManyToOne(fetch= FetchType.LAZY)
    private UserEntity user;

    public PostWebDTO toPostWebDTO() {
        return PostWebDTO.builder().content(content)
                .title(title).build();

    }

    public Post toPost() {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return post;

    }
}
