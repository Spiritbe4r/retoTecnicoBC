package com.banco.comercio.apiblog.adapters.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserWebDTO {

    private String cellPhone;
    private String name;
    private String lastName;
    private String username;
}
