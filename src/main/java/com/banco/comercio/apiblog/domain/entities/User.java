package com.banco.comercio.apiblog.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
public class User {

    private String cellPhone;
    private String name;
    private String lastName;
    private String password;

}
