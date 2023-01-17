package com.banco.comercio.apiblog.adapters.rest.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserDTO {

    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
