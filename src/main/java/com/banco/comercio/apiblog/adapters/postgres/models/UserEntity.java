package com.banco.comercio.apiblog.adapters.postgres.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    private String cellPhone;
    private String name;
    private String lastName;

    private String username;
    private String password;

    @OneToMany(mappedBy="user")
    private List<PostEntity> posts;
}
