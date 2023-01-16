package com.banco.comercio.apiblog.domain.entities;

import com.banco.comercio.apiblog.adapters.postgres.models.BaseEntity;
import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
public class Post {

    private String title;
    private String content;

}
