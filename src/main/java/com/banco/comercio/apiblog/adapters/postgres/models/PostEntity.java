package com.banco.comercio.apiblog.adapters.postgres.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class PostEntity extends BaseEntity {

    private String title;
    private String content;

    @ManyToOne(fetch= FetchType.LAZY)
    private UserEntity user;
}
