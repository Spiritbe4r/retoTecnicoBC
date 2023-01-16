package com.banco.comercio.apiblog.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {

    private String cellPhone;
    private String name;

    private String username;
    private String lastName;
    private String password;
}
