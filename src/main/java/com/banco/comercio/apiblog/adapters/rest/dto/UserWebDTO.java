package com.banco.comercio.apiblog.adapters.rest.dto;

import com.banco.comercio.apiblog.config.enums.UserRoles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserWebDTO {

    private Long id;
    private String cellPhone;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private List<UserRoles> roles;
}
