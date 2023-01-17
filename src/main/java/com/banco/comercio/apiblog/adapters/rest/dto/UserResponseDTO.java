package com.banco.comercio.apiblog.adapters.rest.dto;


import com.banco.comercio.apiblog.config.enums.UserRoles;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserResponseDTO {

    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private Boolean enabled;
    private List<UserRoles> roles ;

}
